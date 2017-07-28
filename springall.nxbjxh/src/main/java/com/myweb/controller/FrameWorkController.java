package com.myweb.controller;

import com.myweb.pojo.Param;
import com.myweb.pojo.Unit;
import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/framework")
public class FrameWorkController {

    @Autowired
    public FrameWorkService frameWorkService;

    //登录
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public Result login(HttpSession session, @ModelAttribute User user,@RequestParam ( "authcode" ) String authcode) {
        return frameWorkService.login(session, user,authcode);
    }

    //注销
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        frameWorkService.logout(session);
        return new ModelAndView("login");
    }

    //注册
    @RequestMapping(value = "regist", method = RequestMethod.GET)
    public ModelAndView update(HttpSession session) {
        Map map = new HashMap();
        return new ModelAndView("register",frameWorkService.regist(session,map));
    }

    //单位
    @ResponseBody
    @RequestMapping(value = "unit", method = RequestMethod.GET)
    public Result unit(HttpSession session,@ModelAttribute Unit unit) {
        return frameWorkService.unit(session,unit);
    }

    //注册
    @ResponseBody
    @RequestMapping(value = "registUser", method = RequestMethod.PUT)
    public Result registUser(HttpSession session,@ModelAttribute User user,@RequestParam ( "authcode" ) String authcode) {
        return frameWorkService.register(session,user,authcode);
    }

    //找回密码
    @ResponseBody
    @RequestMapping(value = "forget", method = RequestMethod.GET)
    public Result forget(HttpSession session,@ModelAttribute User user,@RequestParam ( "authcode" ) String authcode) {
        return frameWorkService.forget(session,user,authcode);
    }
}
