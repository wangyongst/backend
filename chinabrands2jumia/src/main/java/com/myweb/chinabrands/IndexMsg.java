package com.myweb.chinabrands;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IndexMsg extends Result {
    private String sku;
    private String ship_weight;
    private String volume_weight;
    private WareHouse warehouse_list;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getShip_weight() {
        return ship_weight;
    }

    public void setShip_weight(String ship_weight) {
        this.ship_weight = ship_weight;
    }

    public String getVolume_weight() {
        return volume_weight;
    }

    public void setVolume_weight(String volume_weight) {
        this.volume_weight = volume_weight;
    }



    public WareHouse getWarehouse_list() {
        return warehouse_list;
    }

    public void setWarehouse_list(WareHouse warehouse_list) {
        this.warehouse_list = warehouse_list;
    }
}
