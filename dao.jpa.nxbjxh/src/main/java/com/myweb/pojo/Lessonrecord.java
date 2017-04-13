package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-13.
 */
@Entity
public class Lessonrecord {
    private Integer id;
    private Integer lesson;
    private String begintime;
    private String endtime;
    private Integer status;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "lesson", nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
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

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lessonrecord that = (Lessonrecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (lesson != null ? !lesson.equals(that.lesson) : that.lesson != null) return false;
        if (begintime != null ? !begintime.equals(that.begintime) : that.begintime != null) return false;
        if (endtime != null ? !endtime.equals(that.endtime) : that.endtime != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (begintime != null ? begintime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
