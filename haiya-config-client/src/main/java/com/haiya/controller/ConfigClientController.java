package com.haiya.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 一. Nacos作为配置中心的示例
 * 1. 在nacos中添加配置(public下配置，创建的其他namespace下创建会报错Error creating bean with name 'scopedTarget.configClientController': Injection of autowired dependencies failed)
 * 2. 配置的Data ID规则: ${prefix}-${spring.profiles.active}.${file-extension}, 对于本示例来说，就是haiya-config-client-dev.yaml。
 * 3. 配置发布完配置之后，再启动本示例应用。
 * 4. 访问/config/info即可获取配置信息
 *
 * 二. 关于配置设置:
 * 1. 指定profile的情况下，首先去找${appname}-${profile}.yaml配置。
 * 2. 上面配置未找到，找${appname}.yaml配置。
 * 3. 如果还没有找到那就报错
 * 备注: 配置文件中通过spring.cloud.nacos.config的几个属性值配置如何查找配置:
 *  - file-extension: 指定配置的扩展名
 *  - group: 指定配置的组
 *  - prefix: 指定配置的前缀，默认为spring.application.name
 * Data ID规则: ${prefix}-${spring.profiles.active}.${file-extension}
 *
 * 三. SpringBoot读取配置文件的顺序:
 * 1. bootstrap.yml
 * 2. bootstrap.yaml
 * 3. bootstrap.properties
 * 4. nacos的配置
 * 5. application.yml
 * 6. application.yaml
 * 7. application.properties
 *
 * 一旦启动配置客户端，当配置发生变动的时候，会动态刷新
 */
@RequestMapping("/config")
@RestController
@RefreshScope
public class ConfigClientController {
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
