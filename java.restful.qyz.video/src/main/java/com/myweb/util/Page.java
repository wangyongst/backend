package com.myweb.util;

/**
 * Created by BHWL on 2016-12-14.
 */
public class Page {
    private int limit;
    private int offse;
    private String sort;
    private String order;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffse() {
        return offse;
    }

    public void setOffse(int offse) {
        this.offse = offse;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
