package com.myweb.service;


import com.myweb.pojo.Course;
import com.myweb.pojo.Lesson;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface XueXiService {

    public Map makeHome(HttpSession session, Course course, Map map);

    public Map makeLesson(HttpSession session, Lesson lesson, Map map);

}
