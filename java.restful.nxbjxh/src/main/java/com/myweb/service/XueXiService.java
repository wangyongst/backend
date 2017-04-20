package com.myweb.service;


import com.myweb.pojo.*;
import com.myweb.pojo.Number;
import com.myweb.util.Result;
import com.myweb.vo.XueFenVo;
import com.myweb.vo.XueXiVo;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public interface XueXiService {


    public Result updateUser(HttpSession session, User user);

    public Map update(HttpSession session, Map map);

    public Map makeHome(HttpSession session, Course course, Map map);

    public Map makeLesson(HttpSession session, Lesson lesson, Map map);

    public Result bangding(HttpSession session, Number number);

    public Result getTest(HttpSession session, Lesson lesson,Test test);

    public Result postTest(HttpSession session,Lesson lesson,String yes);

    public List<XueFenVo> getXueFen(HttpSession session);

    public List<XueXiVo> getXueXi(HttpSession session);
}
