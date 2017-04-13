package com.myweb.service;

import com.myweb.pojo.Param;
import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface FrameWorkService {

    public Result login(HttpSession session, User user,String authcode);

    public Result logout(HttpSession session);

    public Result register(HttpSession session, User user, String authcode);

    public Map regist(HttpSession session, Map map);

    public Result forget(HttpSession session, User user, String authcode);

}
