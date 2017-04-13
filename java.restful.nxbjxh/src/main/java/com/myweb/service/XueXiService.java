package com.myweb.service;


import com.myweb.pojo.Course;
import com.myweb.pojo.Lesson;
import com.myweb.pojo.Number;
import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface XueXiService {


    public Result updateUser(HttpSession session, User user);

    public Map update(HttpSession session, Map map);

    public Map makeHome(HttpSession session, Course course, Map map);

    public Map makeLesson(HttpSession session, Lesson lesson, Map map);

    public Result bangding(HttpSession session, Number number);
}
