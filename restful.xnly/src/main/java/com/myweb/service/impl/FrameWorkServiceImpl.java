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
    public Result getMenus(HttpSession session, Menu menu) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        ServiceUtils.isReseachListOK(result, frameWorkDao.findMenusByParentAndRole(menu.getParent(), user.getRole()));
        return result;
    }

    @Override
    public Map<String, Object> getMyHome(HttpSession session, Map<String, Object> map) {
        map.put("totalLaoren", frameWorkDao.totalLaoren());
        map.put("totalCaiji", frameWorkDao.totalCaiji());
        map.put("totalFuwuJilu", frameWorkDao.totalFuwu("服务记录"));
        map.put("totalFuwuXuqiu", frameWorkDao.totalFuwu("服务需求"));
        return map;
    }

    @Override
    public Map<String, Object> getUserMenuMap(HttpSession session, Map<String, Object> map) {
        Menu profile = new Menu();
        profile.setName("个人信息");
        profile.setUrl("user/profile.do");
        map.put("profile", profile);
        Menu settings = new Menu();
        settings.setName("账号设置");
        settings.setUrl("user/settings.do");
        map.put("settings", settings);
        Menu logout = new Menu();
        logout.setName("退出登录");
        logout.setUrl("framework/logout.do");
        map.put("logout", logout);
        return map;
    }

    @Override
    public Map<String, Object> getColumnsNameMap(HttpSession session, Map<String, Object> map, String tablename, String columns, boolean isTable) {
        if (StringUtils.isNotBlank(columns)) {
            Tableinfo tableinfo = new Tableinfo();
            tableinfo.setTablename(tablename);
            if (isTable) {
                map.put(columns, frameWorkDao.findTableinfosByDisable(tablename, 0, null));
            } else {
                map.put(columns, frameWorkDao.findTableinfosByDisable(tablename, null, 0));
            }
        }
        return map;
    }

    @Override
    public Result getShuxings(HttpSession session, String name) {
        Result result = new Result();
        if (StringUtils.isNotBlank(name)) {
            ServiceUtils.isReseachListOK(result, frameWorkDao.findShuxingsByName(name));
        }
        return result;
    }

    @Override
    public Result getTableinfos(HttpSession session, String tablename, boolean notTable) {
        Result result = new Result();
        if (StringUtils.isNotBlank(tablename)) {
            Tableinfo tableinfo = new Tableinfo();
            tableinfo.setTablename(tablename);
            if (!notTable) {
                ServiceUtils.isReseachListOK(result, frameWorkDao.findTableinfosByDisable(tablename, 0, null));
            } else {
                ServiceUtils.isReseachListOK(result, frameWorkDao.findTableinfosByDisable(tablename, null, 0));
            }
        } else {
            ServiceUtils.isBlank(result);
        }
        return result;
    }

    @Override
    public Map<String, Object> getTitleMap(HttpSession session, Map<String, Object> map, String title, String tableTitle) {
        map.put("title", title);
        map.put("tableName", tableTitle);
        map.put("home", "menu/myhome.do");
        return map;
    }
}
