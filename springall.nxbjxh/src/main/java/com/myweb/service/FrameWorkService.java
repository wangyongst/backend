package com.myweb.service;

import com.framework.utils.Result;
import com.myweb.pojo.Unit;
import com.myweb.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface FrameWorkService {

    public Result login(HttpSession session, User user, String authcode);

    public Result logout(HttpSession session);

    public Result register(HttpSession session, User user, String authcode);

    public Map regist(HttpSession session, Map map);

    public Result forget(HttpSession session, User user, String authcode);

    public Result unit(HttpSession session, Unit unit);

}
