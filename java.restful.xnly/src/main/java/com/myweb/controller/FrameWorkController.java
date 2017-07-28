package com.myweb.controller;

import com.myweb.pojo.Menu;
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
    public Result login(HttpSession session, @ModelAttribute User user) {
        return frameWorkService.login(session, user);
    }

    //注销
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession session) {
        frameWorkService.logout(session);
        return new ModelAndView("login");
    }

    //首页
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        Map map = new HashMap();
        map = frameWorkService.getUserMenuMap(session, map);
        return new ModelAndView("home", map);
    }

    //获取Tableinfo
    @ResponseBody
    @RequestMapping(value = "/get/menus", method = RequestMethod.GET)
    public Result getMenus(HttpSession session, @ModelAttribute Menu menu) {
        return frameWorkService.getMenus(session, menu);
    }


    //获取Tableinfo
    @ResponseBody
    @RequestMapping(value = "/get/tableinfos/{tablename}/{notTable}", method = RequestMethod.GET)
    public Result getTableinfo(HttpSession session, @PathVariable("tablename") String tablename, @PathVariable("notTable") boolean notTable) {
        return frameWorkService.getTableinfos(session, tablename, notTable);
    }

    //获取Shuxing
    @ResponseBody
    @RequestMapping(value = "/get/shuxings/{name}", method = RequestMethod.GET)
    public Result getShuxing(HttpSession session, @PathVariable("name") String name) {
        return frameWorkService.getShuxings(session, name);
    }
}
