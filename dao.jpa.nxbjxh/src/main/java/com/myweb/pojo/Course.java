package com.myweb.pojo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by BHWL on 2017-04-06.
 */
@Entity
public class Course {
    private String courseId;
    private String courseName;
    private String itemNo;
    private String assignNum;
    private String mainPeople;
    private String expert;
    private String expertUnit;
    private String assignClass;
    private String itemUnit;
    private String year;

    @Id
    @Column(name = "course_id", nullable = false, length = 50)
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name", nullable = true, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "item_no", nullable = true, length = 255)
    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    @Basic
    @Column(name = "assign_num", nullable = true, length = 10)
    public String getAssignNum() {
        return assignNum;
    }

    public void setAssignNum(String assignNum) {
        this.assignNum = assignNum;
    }

    @Basic
    @Column(name = "main_people", nullable = true, length = 50)
    public String getMainPeople() {
        return mainPeople;
    }

    public void setMainPeople(String mainPeople) {
        this.mainPeople = mainPeople;
    }

    @Basic
    @Column(name = "expert", nullable = true, length = 50)
    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    @Basic
    @Column(name = "expert_unit", nullable = true, length = 255)
    public String getExpertUnit() {
        return expertUnit;
    }

    public void setExpertUnit(String expertUnit) {
        this.expertUnit = expertUnit;
    }

    @Basic
    @Column(name = "assign_class", nullable = true, length = 10)
    public String getAssignClass() {
        return assignClass;
    }

    public void setAssignClass(String assignClass) {
        this.assignClass = assignClass;
    }

    @Basic
    @Column(name = "item_unit", nullable = true, length = 255)
    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    @Basic
    @Column(name = "year", nullable = true, length = 10)
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != null ? !courseId.equals(course.courseId) : course.courseId != null) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        if (itemNo != null ? !itemNo.equals(course.itemNo) : course.itemNo != null) return false;
        if (assignNum != null ? !assignNum.equals(course.assignNum) : course.assignNum != null) return false;
        if (mainPeople != null ? !mainPeople.equals(course.mainPeople) : course.mainPeople != null) return false;
        if (expert != null ? !expert.equals(course.expert) : course.expert != null) return false;
        if (expertUnit != null ? !expertUnit.equals(course.expertUnit) : course.expertUnit != null) return false;
        if (assignClass != null ? !assignClass.equals(course.assignClass) : course.assignClass != null) return false;
        if (itemUnit != null ? !itemUnit.equals(course.itemUnit) : course.itemUnit != null) return false;
        if (year != null ? !year.equals(course.year) : course.year != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (itemNo != null ? itemNo.hashCode() : 0);
        result = 31 * result + (assignNum != null ? assignNum.hashCode() : 0);
        result = 31 * result + (mainPeople != null ? mainPeople.hashCode() : 0);
        result = 31 * result + (expert != null ? expert.hashCode() : 0);
        result = 31 * result + (expertUnit != null ? expertUnit.hashCode() : 0);
        result = 31 * result + (assignClass != null ? assignClass.hashCode() : 0);
        result = 31 * result + (itemUnit != null ? itemUnit.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }
}
