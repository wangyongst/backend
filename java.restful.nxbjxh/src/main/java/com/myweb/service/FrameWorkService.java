package com.myweb.service;

import com.myweb.pojo.Menu;
import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface FrameWorkService {

    Result login(HttpSession session, User user);

    Result logout(HttpSession session);

    Result register(HttpSession session, User user);

    Result update(HttpSession session, User user);

}
