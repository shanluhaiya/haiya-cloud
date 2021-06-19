package com.haiya.utils;


/**
 * 返回结果类
 *
 * @param <T>
 * @Author qiaoguoqiang
 */
@Deprecated
public final class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result error() {
        return error(500);
    }

    public static Result error(Integer code) {
        return error(code, "未知错误，请联系管理员");
    }

    public static Result error(Integer code, String msg) {
        return error(code, msg, null);
    }

    public static Result error(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result failure() {
        return failure(500);
    }

    public static Result failure(Integer code) {
        return failure(code, "未知错误，请联系管理员");
    }

    public static Result failure(Integer code, String msg) {
        return failure(code, msg, null);
    }

    public static Result failure(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result ok() {
        return ok(200);
    }

    public static Result ok(Integer code) {
        return ok(code, "OK");
    }

    public static Result ok(Integer code, String msg) {
        return ok(code, msg, null);
    }

    public static Result ok(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }

    public static Result success() {
        return success(200);
    }

    public static Result success(Integer code) {
        return success(code, "OK");
    }

    public static Result success(Integer code, String msg) {
        return success(code, msg, null);
    }

    public static Result success(Integer code, String msg, Object data) {
        return new Result(code, msg, data);
    }
}
