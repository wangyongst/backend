package com.myweb.vo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2017-04-18.
 */

public class XueFenVo {
    private Integer id;
    private String name;
    private String begintime;
    private String endtime;
    private Integer score;
    private String itemno;
    private String unit;
    private String year;

    public XueFenVo(Integer id, String name, String begintime, String endtime, Integer score, String itemno, String unit, String year) {
        this.id = id;
        this.name = name;
        this.begintime = begintime;
        this.endtime = endtime;
        this.score = score;
        this.itemno = itemno;
        this.unit = unit;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
