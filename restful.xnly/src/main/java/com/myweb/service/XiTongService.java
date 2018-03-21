package com.myweb.service;


import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;
import com.myweb.util.Page;
import com.myweb.util.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface XiTongService {

    List<User> listUsers(HttpSession session, User user, Page page);

    List<Laoren> listLaorens(HttpSession session, Laoren laoren, Page page);

    List<Jiashu> listJiashus(HttpSession session, Jiashu jiashu, Page page);


    Result getJiashu(HttpSession session, String id);

    Result getLaoren(HttpSession session, String id);

    Result getUser(HttpSession session, String id);


    Result createLaoren(HttpSession session, Laoren laoren);

    Result createUser(HttpSession session, User user);

    Result createJiashu(HttpSession session, Jiashu jiashu);


    Result updateLaoren(HttpSession session, Laoren laoren);

    Result updateUser(HttpSession session, User user);

    Result updateJiashu(HttpSession session, Jiashu jiashu);

    Result deleteJiashu(HttpSession session, String id);

    Result deleteLaoren(HttpSession session, String id);

    Result deleteUser(HttpSession session, String id);
}
