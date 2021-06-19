package com.haiya.utils.response;

/**
 * 通用响应类,含响应码和响应体
 * 使用方式:
 * 1. Res.ok()
 *    Res.ok(ResCodeEnum.SUCCESS)
 *
 * 2. Res.error()
 *    Res.error(ResCodeEnum.FAIL)
 * @param <T>
 */
public class CommonRes<T> extends SimpleRes {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonRes(ResCodeEnum resCode, T data) {
        super(resCode);
        this.data = data;
    }

    public static CommonRes ok() {
        return ok(ResCodeEnum.SUCCESS);
    }
    public static CommonRes ok(Object data) {
        if (data instanceof ResCodeEnum) {
            return ok((ResCodeEnum) data, null);
        }
        return ok(ResCodeEnum.SUCCESS, data);
    }
    public static CommonRes ok(ResCodeEnum resCode, Object data) {
        return new CommonRes(resCode, data);
    }

    public static CommonRes error() {
        return error(ResCodeEnum.FAIL);
    }

    public static CommonRes error(Object data) {
        if (data instanceof ResCodeEnum) {
            return error((ResCodeEnum) data, null);
        } else {
            return error(ResCodeEnum.FAIL, data);
        }
    }

    public static CommonRes error(ResCodeEnum resCode) {
        return error(resCode, null);
    }

    public static CommonRes error(ResCodeEnum resCode, Object data) {
        return new CommonRes(resCode, data);
    }
}
