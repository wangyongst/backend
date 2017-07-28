package com.myweb.controller;


import com.myweb.pojo.Caiji;
import com.myweb.service.JianKangService;
import com.myweb.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/jiankang")
public class JianKangController {

    @Autowired
    public JianKangService jianKangService;

    @ResponseBody
    @RequestMapping(value = "/list/caijis", method = RequestMethod.GET)
    public List<Caiji> listCaijis(HttpSession session, @ModelAttribute Caiji caiji) {
        return jianKangService.listCaijis(session, caiji);
    }

    @ResponseBody
    @RequestMapping(value = "/get/caiji/{id}", method = RequestMethod.GET)
    public Result getCaiji(HttpSession session, @PathVariable("id") String id) {
        return jianKangService.getCaiji(session, id);
    }

    @ResponseBody
    @RequestMapping(value = "/post/caiji", method = RequestMethod.POST)
    public Result postCaiji(HttpSession session, @ModelAttribute Caiji caiji) {
        return jianKangService.createCaiji(session, caiji);
    }

    @ResponseBody
    @RequestMapping(value = "/put/caiji", method = RequestMethod.PUT)
    public Result putCaiji(HttpSession session, @ModelAttribute Caiji caiji) {
        return jianKangService.updateCaiji(session, caiji);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/caiji/{id}", method = RequestMethod.DELETE)
    public Result deleteCaiji(HttpSession session, @PathVariable("id") String id) {
        return jianKangService.deleteCaiji(session, id);
    }
}
