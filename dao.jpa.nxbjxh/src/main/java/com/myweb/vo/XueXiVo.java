package com.myweb.vo;

/**
 * Created by BHWL on 2017-04-18.
 */

public class XueXiVo {
    private String name;
    private String begintime;
    private String endtime;
    private Integer status;
    private String yes;

    public XueXiVo(Integer id, String name, String begintime, String endtime, Integer status, String cname) {
        this.name = name;
        this.begintime = begintime;
        this.endtime = endtime;
        this.status = status;
        if(status == null || status != 1){
            this.yes = "考试不合格或未考试";
        }else{
            this.yes = "考试合格";
        }
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }
}
