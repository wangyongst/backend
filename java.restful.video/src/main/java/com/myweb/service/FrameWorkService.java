package com.myweb.service;

import com.myweb.pojo.User;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;

public interface FrameWorkService {

    public Result login(HttpSession session, User user);

    public Result playVideo(String platformid, String url, String password);

    public Result listPlatform(HttpSession session);

    public Result playDefaultVideo();
}
