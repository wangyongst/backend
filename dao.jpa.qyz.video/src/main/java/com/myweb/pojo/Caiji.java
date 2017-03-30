package com.myweb.pojo;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by wangy on 2016-12-19.
 */
@Entity
@Table(name = "caiji")
public class Caiji {
    private Integer id;
    private Integer laorenid;
    private String laorenname;
    private Integer gaoya;
    private Integer diya;
    private BigDecimal xuetang;
    private Integer maibo;
    private Integer xueyang;
    private BigDecimal tizhong;
    private Integer shengao;
    private BigDecimal bmi;
    private Integer huxi;
    private String time;
    private Integer createuser;
    private String createusername;
    private String createtime;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "laorenid", nullable = true)
    public Integer getLaorenid() {
        return laorenid;
    }

    public void setLaorenid(Integer laorenid) {
        this.laorenid = laorenid;
    }

    @Basic
    @Column(name = "laorenname", nullable = true, length = 255)
    public String getLaorenname() {
        return laorenname;
    }

    public void setLaorenname(String laorenname) {
        this.laorenname = laorenname;
    }

    @Basic
    @Column(name = "gaoya", nullable = true)
    public Integer getGaoya() {
        return gaoya;
    }

    public void setGaoya(Integer gaoya) {
        this.gaoya = gaoya;
    }

    @Basic
    @Column(name = "diya", nullable = true)
    public Integer getDiya() {
        return diya;
    }

    public void setDiya(Integer diya) {
        this.diya = diya;
    }

    @Basic
    @Column(name = "xuetang", nullable = true, precision = 2)
    public BigDecimal getXuetang() {
        return xuetang;
    }

    public void setXuetang(BigDecimal xuetang) {
        this.xuetang = xuetang;
    }

    @Basic
    @Column(name = "maibo", nullable = true)
    public Integer getMaibo() {
        return maibo;
    }

    public void setMaibo(Integer maibo) {
        this.maibo = maibo;
    }

    @Basic
    @Column(name = "xueyang", nullable = true)
    public Integer getXueyang() {
        return xueyang;
    }

    public void setXueyang(Integer xueyang) {
        this.xueyang = xueyang;
    }

    @Basic
    @Column(name = "tizhong", nullable = true, precision = 2)
    public BigDecimal getTizhong() {
        return tizhong;
    }

    public void setTizhong(BigDecimal tizhong) {
        this.tizhong = tizhong;
    }

    @Basic
    @Column(name = "shengao", nullable = true)
    public Integer getShengao() {
        return shengao;
    }

    public void setShengao(Integer shengao) {
        this.shengao = shengao;
    }

    @Basic
    @Column(name = "bmi", nullable = true, precision = 2)
    public BigDecimal getBmi() {
        return bmi;
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    @Basic
    @Column(name = "huxi", nullable = true)
    public Integer getHuxi() {
        return huxi;
    }

    public void setHuxi(Integer huxi) {
        this.huxi = huxi;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 255)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "createuser", nullable = true)
    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    @Basic
    @Column(name = "createusername", nullable = true, length = 255)
    public String getCreateusername() {
        return createusername;
    }

    public void setCreateusername(String createusername) {
        this.createusername = createusername;
    }

    @Basic
    @Column(name = "createtime", nullable = true, length = 255)
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Caiji caiji = (Caiji) o;

        if (id != null ? !id.equals(caiji.id) : caiji.id != null) return false;
        if (laorenid != null ? !laorenid.equals(caiji.laorenid) : caiji.laorenid != null) return false;
        if (laorenname != null ? !laorenname.equals(caiji.laorenname) : caiji.laorenname != null) return false;
        if (gaoya != null ? !gaoya.equals(caiji.gaoya) : caiji.gaoya != null) return false;
        if (diya != null ? !diya.equals(caiji.diya) : caiji.diya != null) return false;
        if (xuetang != null ? !xuetang.equals(caiji.xuetang) : caiji.xuetang != null) return false;
        if (maibo != null ? !maibo.equals(caiji.maibo) : caiji.maibo != null) return false;
        if (xueyang != null ? !xueyang.equals(caiji.xueyang) : caiji.xueyang != null) return false;
        if (tizhong != null ? !tizhong.equals(caiji.tizhong) : caiji.tizhong != null) return false;
        if (shengao != null ? !shengao.equals(caiji.shengao) : caiji.shengao != null) return false;
        if (bmi != null ? !bmi.equals(caiji.bmi) : caiji.bmi != null) return false;
        if (huxi != null ? !huxi.equals(caiji.huxi) : caiji.huxi != null) return false;
        if (time != null ? !time.equals(caiji.time) : caiji.time != null) return false;
        if (createuser != null ? !createuser.equals(caiji.createuser) : caiji.createuser != null) return false;
        if (createusername != null ? !createusername.equals(caiji.createusername) : caiji.createusername != null) return false;
        if (createtime != null ? !createtime.equals(caiji.createtime) : caiji.createtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (laorenid != null ? laorenid.hashCode() : 0);
        result = 31 * result + (laorenname != null ? laorenname.hashCode() : 0);
        result = 31 * result + (gaoya != null ? gaoya.hashCode() : 0);
        result = 31 * result + (diya != null ? diya.hashCode() : 0);
        result = 31 * result + (xuetang != null ? xuetang.hashCode() : 0);
        result = 31 * result + (maibo != null ? maibo.hashCode() : 0);
        result = 31 * result + (xueyang != null ? xueyang.hashCode() : 0);
        result = 31 * result + (tizhong != null ? tizhong.hashCode() : 0);
        result = 31 * result + (shengao != null ? shengao.hashCode() : 0);
        result = 31 * result + (bmi != null ? bmi.hashCode() : 0);
        result = 31 * result + (huxi != null ? huxi.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (createuser != null ? createuser.hashCode() : 0);
        result = 31 * result + (createusername != null ? createusername.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        return result;
    }
}
