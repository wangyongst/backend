package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2017-06-01.
 */
@Entity
public class Zhongjiang {
    private Integer id;
    private Integer r1;
    private Integer r2;
    private Integer r3;
    private Integer r4;
    private Integer r5;
    private Integer b;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "r1", nullable = false)
    public Integer getR1() {
        return r1;
    }

    public void setR1(Integer r1) {
        this.r1 = r1;
    }

    @Basic
    @Column(name = "r2", nullable = false)
    public Integer getR2() {
        return r2;
    }

    public void setR2(Integer r2) {
        this.r2 = r2;
    }

    @Basic
    @Column(name = "r3", nullable = false)
    public Integer getR3() {
        return r3;
    }

    public void setR3(Integer r3) {
        this.r3 = r3;
    }

    @Basic
    @Column(name = "r4", nullable = false)
    public Integer getR4() {
        return r4;
    }

    public void setR4(Integer r4) {
        this.r4 = r4;
    }

    @Basic
    @Column(name = "r5", nullable = false)
    public Integer getR5() {
        return r5;
    }

    public void setR5(Integer r5) {
        this.r5 = r5;
    }

    @Basic
    @Column(name = "b", nullable = false)
    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zhongjiang that = (Zhongjiang) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (r1 != null ? !r1.equals(that.r1) : that.r1 != null) return false;
        if (r2 != null ? !r2.equals(that.r2) : that.r2 != null) return false;
        if (r3 != null ? !r3.equals(that.r3) : that.r3 != null) return false;
        if (r4 != null ? !r4.equals(that.r4) : that.r4 != null) return false;
        if (r5 != null ? !r5.equals(that.r5) : that.r5 != null) return false;
        if (b != null ? !b.equals(that.b) : that.b != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (r1 != null ? r1.hashCode() : 0);
        result = 31 * result + (r2 != null ? r2.hashCode() : 0);
        result = 31 * result + (r3 != null ? r3.hashCode() : 0);
        result = 31 * result + (r4 != null ? r4.hashCode() : 0);
        result = 31 * result + (r5 != null ? r5.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        return result;
    }
}
