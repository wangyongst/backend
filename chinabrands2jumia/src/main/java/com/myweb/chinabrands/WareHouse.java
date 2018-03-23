package com.myweb.chinabrands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WareHouse {
    @JsonProperty("YB")
    private Index YB;

    @JsonProperty("FXQHBSWH")
    private Index FXQHBSWH;


    public Index getYB() {
        return YB;
    }

    public void setYB(Index YB) {
        this.YB = YB;
    }

    public Index getFXQHBSWH() {
        return FXQHBSWH;
    }

    public void setFXQHBSWH(Index FXQHBSWH) {
        this.FXQHBSWH = FXQHBSWH;
    }
}
