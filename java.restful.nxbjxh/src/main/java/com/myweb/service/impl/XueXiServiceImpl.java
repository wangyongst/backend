package com.myweb.service.impl;

import com.myweb.dao.jpa.hibernate.CourseRepository;
import com.myweb.dao.jpa.hibernate.LessonRepository;
import com.myweb.pojo.Course;
import com.myweb.pojo.Lesson;
import com.myweb.service.XueXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Service("xueXiService")
@Transactional(value = "myTM", readOnly = true)
public class XueXiServiceImpl implements XueXiService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Override
    public Map makeHome(HttpSession session, Course course, Map map) {
        if(course.getId() == null || course.getId() == 0) course.setId(1);
        map.put("total",courseRepository.count());
        map.put("currentCourse",courseRepository.findOne(course.getId()));
        map.put("lessons",lessonRepository.findByCourse(course.getId()));
        return map;
    }

    @Override
    public Map makeLesson(HttpSession session, Lesson lesson, Map map) {
        map.put("currentLesson",lessonRepository.findOne(lesson.getId()));
        return null;
    }
}
