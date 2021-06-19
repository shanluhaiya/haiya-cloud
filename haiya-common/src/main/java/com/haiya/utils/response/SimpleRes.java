package com.haiya.utils.response;

import com.haiya.utils.response.api.ResultInterface;

/**
 * 简明响应类，仅含响应码
 * @author qiaoguoqiang
 */
public class SimpleRes implements ResultInterface {
    /**
     * 操作是否成功
     */
    public boolean success = SUCCESS;

    /**
     * 操作响应码
     */
    public int code = SUCCESS_CODE;

    /**
     * 操作提示信息
     */
    public String msg;

    public SimpleRes(ResCodeEnum resCode) {
        this.success = resCode.success;
        this.code = resCode.code;
        this.msg = resCode.msg;
    }
}
