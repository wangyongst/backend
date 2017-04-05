package com.myweb.service.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.pojo.Menu;
import com.myweb.pojo.Tableinfo;
import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private FrameWorkDao frameWorkDao;

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = frameWorkDao.findUsersByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }


    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return new Result();
    }

    @Override
    public Result register(HttpSession session, User user) {
        return null;
    }

    @Override
    public Result update(HttpSession session, User user) {
        return null;
    }


}
