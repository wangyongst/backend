package com.myweb.vo;

/**
 * Created by BHWL on 2017-04-18.
 */

public class XueFenVo {
    private Integer id;
    private String name;
    private String begintime;
    private String endtime;
    private Integer score;
    private String year;
    private Integer status;
    private String xuefen;

    public XueFenVo(Integer id, String name, String begintime, String endtime, Integer score, String year, Integer status) {
        this.id = id;
        this.name = "<a href=\"javascript:makeXuexi("+id+");\">" + name + "</a>";
        this.begintime = begintime;
        this.endtime = endtime;
        this.score = score;
        this.year = year;
        if (status != null && status == 3) {
            this.xuefen = "已获得学分";
        } else if (status != null && status == 2) {
            this.xuefen = "学习完毕&nbsp;&nbsp;&nbsp;&nbsp;<button onclick=\"show()\" type=\"button\" class=\"btn btn-success\">申请学分</button>";
        } else {
            this.xuefen = "学习中";
        }
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getXuefen() {
        return xuefen;
    }

    public void setXuefen(String xuefen) {
        this.xuefen = xuefen;
    }
}
