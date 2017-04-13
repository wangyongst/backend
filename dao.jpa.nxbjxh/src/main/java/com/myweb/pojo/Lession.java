package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-13.
 */
@Entity
public class Lession {
    private Integer id;
    private String course;
    private String name;
    private String teacher;
    private String title;
    private String introduce;
    private String picture;
    private String url;

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
    @Column(name = "course", nullable = true, length = 255)
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "teacher", nullable = true, length = 255)
    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "introduce", nullable = true, length = 255)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    @Basic
    @Column(name = "picture", nullable = true, length = 255)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lession lession = (Lession) o;

        if (id != null ? !id.equals(lession.id) : lession.id != null) return false;
        if (course != null ? !course.equals(lession.course) : lession.course != null) return false;
        if (name != null ? !name.equals(lession.name) : lession.name != null) return false;
        if (teacher != null ? !teacher.equals(lession.teacher) : lession.teacher != null) return false;
        if (title != null ? !title.equals(lession.title) : lession.title != null) return false;
        if (introduce != null ? !introduce.equals(lession.introduce) : lession.introduce != null) return false;
        if (picture != null ? !picture.equals(lession.picture) : lession.picture != null) return false;
        if (url != null ? !url.equals(lession.url) : lession.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
