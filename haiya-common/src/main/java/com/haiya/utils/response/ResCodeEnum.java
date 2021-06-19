package com.haiya.utils.response;

import com.haiya.utils.response.api.CodeInterface;

/**
 * 海涯平台响应码枚举类
 *
 * 10000-- 通用错误代码
 * 22000-- 媒资错误代码
 * 23000-- 用户中心错误代码
 * 24000-- cms错误代码
 * 25000-- 文件系统
 *
 * @author qiaoguoqiang
 */
public enum ResCodeEnum implements CodeInterface {
    /**
     * 成功
     */
    SUCCESS(true, 10000, "操作成功！"),
    /**
     * 未登陆
     */
    UNAUTHENTICATED(false, 10001, "此操作需要登陆系统！"),
    /**
     * 无权限
     */
    UNAUTHORISE(false, 10002, "权限不足，无权操作！"),
    /**
     * 非法参数
     */
    INVALID_PARAM(false,10003,"非法参数！"),

    /**
     * 操作失败
     */
    FAIL(false, 11111, "操作失败！"),
    /**
     * 系统繁忙
     */
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    /**
     * 操作是否成功
     */
    boolean success;

    /**
     * 操作响应码
     */
    int code;

    /**
     * 提示信息
     */
    String msg;

    ResCodeEnum(boolean success, int code, String msg) {
        this.success = success;
        this.code = code;
        this.msg = msg;
    }

    @Override
    public boolean success() {
        return false;
    }

    @Override
    public int code() {
        return 0;
    }

    @Override
    public String msg() {
        return null;
    }
}
