package com.myweb.chinabrands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockMsg {
    private List<Stock> page_result;

    public List<Stock> getPage_result() {
        return page_result;
    }

    public void setPage_result(List<Stock> page_result) {
        this.page_result = page_result;
    }
}
