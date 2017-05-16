package com.myweb.pojo;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-18.
 */
@Entity
@Table(name = "test")
public class Test implements Comparable<Test>{
    private Integer id;
    private Integer lesson;
    private Integer ord;
    private String name;
    private Integer test;
    private Integer multi;
    private Integer yes;

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
    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "ord", nullable = false)
    public Integer getOrd() {
        return ord;
    }

    public void setOrd(Integer ord) {
        this.ord = ord;
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
    @Column(name = "test", nullable = true)
    public Integer getTest() {
        return test;
    }

    public void setTest(Integer test) {
        this.test = test;
    }

    @Basic
    @Column(name = "multi", nullable = true)
    public Integer getMulti() {
        return multi;
    }

    public void setMulti(Integer multi) {
        this.multi = multi;
    }

    @Basic
    @Column(name = "yes", nullable = true)
    public Integer getYes() {
        return yes;
    }

    public void setYes(Integer yes) {
        this.yes = yes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test1 = (Test) o;

        if (id != null ? !id.equals(test1.id) : test1.id != null) return false;
        if (lesson != null ? !lesson.equals(test1.lesson) : test1.lesson != null) return false;
        if (ord != null ? !ord.equals(test1.ord) : test1.ord != null) return false;
        if (name != null ? !name.equals(test1.name) : test1.name != null) return false;
        if (test != null ? !test.equals(test1.test) : test1.test != null) return false;
        if (multi != null ? !multi.equals(test1.multi) : test1.multi != null) return false;
        if (yes != null ? !yes.equals(test1.yes) : test1.yes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (ord != null ? ord.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (test != null ? test.hashCode() : 0);
        result = 31 * result + (multi != null ? multi.hashCode() : 0);
        result = 31 * result + (yes != null ? yes.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NotNull Test o) {
        return this.ord - o.ord;
    }
}
