package com.myweb.dao;

import com.myweb.pojo.Menu;
import com.myweb.pojo.Shuxing;
import com.myweb.pojo.Tableinfo;
import com.myweb.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface FrameWorkDao {

    List<User> findUsersByUsernameAndPassword(String username, String password);

}
