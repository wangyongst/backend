package com.myweb.service;


import com.myweb.pojo.Course;
import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface XueXiService {

    public Map makeHome(HttpSession session, Course course,Map map);

}
