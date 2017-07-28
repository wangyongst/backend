package com.myweb.dao;

import com.myweb.pojo.Menu;
import com.myweb.pojo.Shuxing;
import com.myweb.pojo.Tableinfo;
import com.myweb.pojo.User;

import java.util.List;

public interface FrameWorkDao {

    List<User> findUsersByUsernameAndPassword(String username, String password);

    public List<Menu> findMenusByParentAndRole(int parent, String role);

    public long totalLaoren();

    public long totalCaiji();

    public long totalFuwu(String fuwutype);

    public List<Tableinfo> findTableinfosByDisable(String tablename, Integer tabledisable, Integer modaldisable);

    public List<Shuxing> findShuxingsByName(String name);

}
