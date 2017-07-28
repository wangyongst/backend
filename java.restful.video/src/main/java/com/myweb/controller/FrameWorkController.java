package com.myweb.controller;

import com.myweb.pojo.User;
import com.myweb.pojo.Video;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FrameWorkController {

    @Autowired
    public FrameWorkService frameWorkService;

    @ResponseBody
    @RequestMapping(value = "/video/{platformid}/{password}", method = RequestMethod.GET)
    public Result video(HttpSession session, String url, @PathVariable("platformid") String platformid, @PathVariable("password") String password) {
        return frameWorkService.playVideo(platformid,url, password);
    }

    //登录
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public Result login(HttpSession session, @ModelAttribute User user) {
        return frameWorkService.login(session, user);
    }


    @ResponseBody
    @RequestMapping(value = "/listPlatform", method = RequestMethod.GET)
    public Result listPlatform(HttpSession session) {
        return frameWorkService.listPlatform(session);
    }


    //首页
    @RequestMapping(value = "home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session) {
        Map map = new HashMap();
        map.put("homevideo",frameWorkService.playDefaultVideo().getData());
        return new ModelAndView("home", map);
    }
}
