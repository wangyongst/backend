package com.myweb.pojo;

import javax.persistence.*;

/**
 * Created by BHWL on 2017-04-13.
 */
@Entity
public class Test {
    private Integer id;
    private Integer lesson;
    private Integer order;
    private String name;

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
    @Column(name = "lesson", nullable = false)
    public Integer getLesson() {
        return lesson;
    }

    public void setLesson(Integer lesson) {
        this.lesson = lesson;
    }

    @Basic
    @Column(name = "order", nullable = false)
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Test test = (Test) o;

        if (id != null ? !id.equals(test.id) : test.id != null) return false;
        if (lesson != null ? !lesson.equals(test.lesson) : test.lesson != null) return false;
        if (order != null ? !order.equals(test.order) : test.order != null) return false;
        if (name != null ? !name.equals(test.name) : test.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lesson != null ? lesson.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
