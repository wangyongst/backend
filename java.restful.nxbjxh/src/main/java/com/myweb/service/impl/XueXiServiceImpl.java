package com.myweb.service.impl;

import com.myweb.dao.jpa.hibernate.CourseRepository;
import com.myweb.dao.jpa.hibernate.LessonRepository;
import com.myweb.pojo.Course;
import com.myweb.service.XueXiService;
import com.myweb.util.Result;
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
    public Map makeHome(HttpSession session, Course course,Map map) {
        map.put("totalCourse",courseRepository.count());
        map.put("currentCourse",courseRepository.findOne(course.getId()).getName());
        map.put("lessons",lessonRepository.find)
        return null;
    }
}
