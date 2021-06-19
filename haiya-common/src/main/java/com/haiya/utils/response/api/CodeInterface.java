package com.haiya.utils.response.api;

/**
 * 响应码
 * @author qiaoguoqiang
 */
public interface CodeInterface {
    /**
     * 操作是否成功,true为成功，false操作失败
     *
     * @return
     */
    boolean success();

    /**
     * 响应码
     *
     * @return
     */
    int code();

    /**
     * 响应提示信息
     *
     * @return
     */
    String msg();
}
