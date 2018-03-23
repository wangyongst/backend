package com.myweb.jumia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Head {
    @JsonProperty("Head")
    private ErrorMsg Head;

    public ErrorMsg getHead() {
        return Head;
    }

    public void setHead(ErrorMsg head) {
        Head = head;
    }
}
