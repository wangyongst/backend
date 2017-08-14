package myweb.vo;

import myweb.pojo.Lesson;

/**
 * Created by BHWL on 2017-06-22.
 */
public class LessonVo extends Lesson {
    private Integer status;
    private String yes;

    public LessonVo(Lesson lesson,Integer status) {
        super();
        this.setId(lesson.getId());
        this.setIntroduce(lesson.getIntroduce());
        this.setName(lesson.getName());
        this.setPicture(lesson.getPicture());
        this.status = status;
        if (status == null) {
            this.yes = "未学习";
        } else if (status == 1) {
            this.yes = "考试合格";
        } else {
            this.yes = "考试不合格或未考试";
        }
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }
}
