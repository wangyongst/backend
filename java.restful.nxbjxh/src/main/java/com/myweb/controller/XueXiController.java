package com.myweb.controller;


import com.myweb.pojo.Course;
import com.myweb.pojo.Lesson;
import com.myweb.service.XueXiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/xuexi")
public class XueXiController {

    @Autowired
    private XueXiService xueXiService;

    //首页
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session, @ModelAttribute Course course) {
        Map map = new HashMap();
        return new ModelAndView("xuexi/home", xueXiService.makeHome(session,course,map));
    }

    //Lesson
    @RequestMapping(value = "lesson", method = RequestMethod.GET)
    public ModelAndView lesson(HttpSession session, @ModelAttribute Lesson lesson) {
        Map map = new HashMap();
        return new ModelAndView("xuexi/xuexi", xueXiService.makeLesson(session,lesson,map));
    }
}
