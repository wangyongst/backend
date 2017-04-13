package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-13.
 */
@Entity
public class Courserecord {
    private Integer id;
    private Integer course;
    private String begintime;
    private String endtime;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "course", nullable = false)
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Basic
    @Column(name = "begintime", nullable = true, length = 255)
    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    @Basic
    @Column(name = "endtime", nullable = true, length = 255)
    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Courserecord that = (Courserecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (course != null ? !course.equals(that.course) : that.course != null) return false;
        if (begintime != null ? !begintime.equals(that.begintime) : that.begintime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        return result;
    }
}
