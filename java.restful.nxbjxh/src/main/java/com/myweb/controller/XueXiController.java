package com.myweb.controller;


import com.myweb.pojo.Course;
import com.myweb.pojo.Lesson;
import com.myweb.pojo.Number;
import com.myweb.pojo.User;
import com.myweb.service.XueXiService;
import com.myweb.util.Result;
import org.apache.commons.lang3.StringUtils;
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


    //修改
    @ResponseBody
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public Result updateUser(HttpSession session, @ModelAttribute User user) {
        return xueXiService.updateUser(session,user);
    }

    //修改
    @RequestMapping(value = "update", method = RequestMethod.GET)
    public ModelAndView update(HttpSession session) {
        Map map = new HashMap();
        return new ModelAndView("xuexi/update",xueXiService.update(session,map));
    }

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

    //绑定
    @ResponseBody
    @RequestMapping(value = "bangding", method = RequestMethod.PUT)
    public Result bangding(HttpSession session, @ModelAttribute Number number) {
        User user = (User)session.getAttribute("user");
        if(!StringUtils.isBlank(user.getNumber())){
            return new Result();
        }else{
            return xueXiService.bangding(session,number);
        }
    }

    //学分
    @RequestMapping(value = "xuefen", method = RequestMethod.GET)
    public ModelAndView xuefen(HttpSession session) {
        User user = (User)session.getAttribute("user");
        if(StringUtils.isBlank(user.getNumber())) return new ModelAndView("xuexi/bangding");
        else{
            return new ModelAndView("xuexi/xuefen");
        }
    }
}
