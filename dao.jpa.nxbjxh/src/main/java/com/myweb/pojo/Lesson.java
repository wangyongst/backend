package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-13.
 */
@Entity
public class Lesson {
    private Integer id;
    private Integer course;
    private String name;
    private String teacher;
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
    @Column(name = "course", nullable = false)
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
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

        Lesson lesson = (Lesson) o;

        if (id != null ? !id.equals(lesson.id) : lesson.id != null) return false;
        if (course != null ? !course.equals(lesson.course) : lesson.course != null) return false;
        if (name != null ? !name.equals(lesson.name) : lesson.name != null) return false;
        if (teacher != null ? !teacher.equals(lesson.teacher) : lesson.teacher != null) return false;
        if (introduce != null ? !introduce.equals(lesson.introduce) : lesson.introduce != null) return false;
        if (picture != null ? !picture.equals(lesson.picture) : lesson.picture != null) return false;
        if (url != null ? !url.equals(lesson.url) : lesson.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (introduce != null ? introduce.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
