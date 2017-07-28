package com.myweb.controller;


import com.myweb.dao.ShengHuoDao;
import com.myweb.pojo.Fuwu;
import com.myweb.service.ShengHuoService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/shenghuo")
public class ShengHuoController {

    @Autowired
    public ShengHuoService shengHuoService;

    @ResponseBody
    @RequestMapping(value = "/list/fuwus", method = RequestMethod.GET)
    public List<Fuwu> listFuwus(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shengHuoService.listFuwus(session, fuwu);
    }

    @ResponseBody
    @RequestMapping(value = "/get/fuwu/{id}", method = RequestMethod.GET)
    public Result getFuwu(HttpSession session, @PathVariable("id") String id) {
        return shengHuoService.getFuwu(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/post/fuwu", method = RequestMethod.POST)
    public Result postFuwu(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shengHuoService.createFuwu(session, fuwu);
    }


    @ResponseBody
    @RequestMapping(value = "/put/fuwu", method = RequestMethod.PUT)
    public Result putFuwu(HttpSession session, @ModelAttribute Fuwu fuwu) {
        return shengHuoService.updateFuwu(session, fuwu);
    }


    @ResponseBody
    @RequestMapping(value = "/delete/fuwu/{id}", method = RequestMethod.DELETE)
    public Result deleteFuwu(HttpSession session, @PathVariable("id") String id) {
        return shengHuoService.deleteFuwu(session, id);
    }
}
