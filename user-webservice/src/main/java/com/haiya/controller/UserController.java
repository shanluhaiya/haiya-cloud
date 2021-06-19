package com.haiya.controller;

import com.haiya.component.ServerConfig;
import com.haiya.po.User;
import com.haiya.service.UserService;
import com.haiya.utils.request.Query;
import com.haiya.utils.response.CommonRes;
import com.haiya.utils.response.PageRes;
import com.haiya.utils.response.ResCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ServerConfig serverConfig;

    /**
     * 参照@RequestParam 和 @RequestBody区别
     * @param params
     * @return
     */
    @RequestMapping("/list")
    public CommonRes list(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<User> users = userService.queryList(query);
        int total = userService.queryTotal(query);
        PageRes result = new PageRes(users, total, query.getLimit(), query.getPage());
        return CommonRes.ok(result);
    }

    @GetMapping("/info/{id}")
    public CommonRes info(@PathVariable("id") String id) {
        System.out.println(serverConfig.getUrl());
        return CommonRes.ok(userService.info(id));
    }

    @PostMapping("/create")
    public CommonRes create(@RequestBody User user) {
        if (user.getUsername() == null) {
            return CommonRes.error(ResCodeEnum.INVALID_PARAM);
        }

        Date currentTime = new Date();
        String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
        user.setId(uuid);
        user.setCreateTime(currentTime);
        user.setModifyTime(currentTime);
        user.setLoginTime(currentTime);
        int ret = userService.create(user);

        if (ret > 0) {
            return CommonRes.ok(ret);
        }

        return CommonRes.error();
    }

    @PutMapping("/update")
    public CommonRes update(@RequestBody User user) {
        if (user.getId() == null) {
            return CommonRes.error(ResCodeEnum.INVALID_PARAM);
        }
        int ret = userService.updateById(user);

        if (ret > 0) {
            return CommonRes.ok(ret);
        }

        return CommonRes.error(ret);
    }
}