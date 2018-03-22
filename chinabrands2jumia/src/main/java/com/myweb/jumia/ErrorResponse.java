package com.myweb.jumia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {
    private Head Head;

    public com.myweb.jumia.Head getHead() {
        return Head;
    }

    public void setHead(com.myweb.jumia.Head head) {
        Head = head;
    }
}
