package com.haiya.utils.response;

import java.io.Serializable;
import java.util.List;

public class PageRes implements Serializable {
    private static final long serialVersionUID = 1L;

    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int curPage;
    private List<?> list;

    /**
     * 分页工具构造器
     * @param list              列表数据
     * @param totalCount        总记录数
     * @param pageSize          每页记录数
     * @param curPage           当前页数
     */
    public PageRes(List<?> list, int totalCount, int pageSize, int curPage) {
        this.list = list;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.curPage = curPage;
        this.totalPage = (int)Math.ceil((double)totalCount/pageSize);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
