package com.myweb.controller;

import com.myweb.service.FrameWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BHWL on 2016-12-15.
 */


@Controller
@RequestMapping(value = "/menu")
public class MenuController {
    @Autowired
    public FrameWorkService userService;

    //生成JSP页面

    @RequestMapping(value = "/xitong/user", method = RequestMethod.GET)
    public ModelAndView user(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getColumnsNameMap(session, map, "user", "tableColumns", true);
        map = userService.getTitleMap(session, map, "用户管理", "用户信息表");
        return new ModelAndView("xitong/user", map);
    }

    @RequestMapping(value = "/xitong/laoren/{type}", method = RequestMethod.GET)
    public ModelAndView laoren(HttpSession session, @PathVariable("type") String type) {
        Map map = new HashMap<String, String>();
        if (type.equals("1")) {
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            map = userService.getTitleMap(session, map, "低收入老人管理", "低收入老人信息表");
            return new ModelAndView("xitong/dSRLaoren", map);
        } else if (type.equals("2")) {
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            map = userService.getTitleMap(session, map, "饮马街街道老人管理", "饮马街街道老人信息表");
            return new ModelAndView("xitong/yMJLaoren", map);
        } else {
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            map = userService.getTitleMap(session, map, "老人管理", "老人信息表");
            return new ModelAndView("xitong/laoren", map);
        }
    }

    @RequestMapping(value = "/xitong/jiashu", method = RequestMethod.GET)
    public ModelAndView laorenJiashu(HttpSession session) {
        Map map = new HashMap<String, String>();
        map = userService.getTitleMap(session, map, "老人家属管理", "老人家属信息表");
        map = userService.getColumnsNameMap(session, map, "jiashu", "tableColumns", true);
        return new ModelAndView("xitong/jiashu", map);
    }

    @RequestMapping(value = "/myhome", method = RequestMethod.GET)
    public ModelAndView myhome(HttpSession session) {
        Map map = new HashMap();
        map.put("title", "我的首页");
        map = userService.getMyHome(session, map);
        return new ModelAndView("default_home", map);
    }

    @RequestMapping(value = "/shenghuo/fuwu/{type}", method = RequestMethod.GET)
    public ModelAndView fuwu(HttpSession session, @PathVariable("type") String type) {
        Map map = new HashMap<String, String>();
        if (type.equals("服务需求")) {
            map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
            map = userService.getTitleMap(session, map, "服务需求管理", "服务需求表");
            return new ModelAndView("shenghuo/xuqiu", map);
        } else if (type.equals("服务记录")) {
            map = userService.getColumnsNameMap(session, map, "fuwu", "tableColumns", true);
            map = userService.getTitleMap(session, map, "服务记录管理", "服务记录表");
            return new ModelAndView("shenghuo/jilu", map);
        } else {
            map = userService.getTitleMap(session, map, "服务记录/需求登记", "老人信息表");
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            return new ModelAndView("shenghuo/fuwu", map);
        }
    }

    @RequestMapping(value = "/jiankang/caiji/{type}/{laorenid}", method = RequestMethod.GET)
    public ModelAndView caiji(HttpSession session, @PathVariable("type") String type, @PathVariable("laorenid") String laorenid) {
        Map map = new HashMap<String, String>();
        if (type.equals("1")) {
            map = userService.getTitleMap(session, map, "健康趋势", "老人信息表");
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            return new ModelAndView("jiankang/qushi", map);
        } else if (type.equals("2")) {
            map = userService.getTitleMap(session, map, "健康数据管理", "健康数据表");
            map = userService.getColumnsNameMap(session, map, "caiji", "tableColumns", true);
            return new ModelAndView("jiankang/shuju", map);
        } else if (type.equals("3")) {
            map = userService.getTitleMap(session, map, "健康数据趋势", "健康数据表");
            map.put("laorenid",laorenid);
            map = userService.getColumnsNameMap(session, map, "caiji", "tableColumns", true);
            map.put("laorenid", laorenid);
            return new ModelAndView("jiankang/qushishuju", map);
        } else {
            map = userService.getTitleMap(session, map, "健康数据采集", "老人信息表");
            map = userService.getColumnsNameMap(session, map, "laoren", "tableColumns", true);
            return new ModelAndView("jiankang/caiji", map);
        }
    }
}
