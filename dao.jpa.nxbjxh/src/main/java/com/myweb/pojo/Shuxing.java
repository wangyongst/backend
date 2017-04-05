package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by wangy on 2016-12-19.
 */
@Entity
@Table(name = "shuxing")
public class Shuxing {
    private Integer id;
    private String chinese;
    private String name;
    private String chinesename;
    private String remark;
    private Integer shunxu;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chinese")
    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "chinesename")
    public String getChinesename() {
        return chinesename;
    }

    public void setChinesename(String chinesename) {
        this.chinesename = chinesename;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "shunxu")
    public Integer getShunxu() {
        return shunxu;
    }

    public void setShunxu(Integer shunxu) {
        this.shunxu = shunxu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shuxing shuxing = (Shuxing) o;

        if (id != null ? !id.equals(shuxing.id) : shuxing.id != null) return false;
        if (chinese != null ? !chinese.equals(shuxing.chinese) : shuxing.chinese != null) return false;
        if (name != null ? !name.equals(shuxing.name) : shuxing.name != null) return false;
        if (chinesename != null ? !chinesename.equals(shuxing.chinesename) : shuxing.chinesename != null) return false;
        if (remark != null ? !remark.equals(shuxing.remark) : shuxing.remark != null) return false;
        if (shunxu != null ? !shunxu.equals(shuxing.shunxu) : shuxing.shunxu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (chinese != null ? chinese.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (chinesename != null ? chinesename.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (shunxu != null ? shunxu.hashCode() : 0);
        return result;
    }
}
