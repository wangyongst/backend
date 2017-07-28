package com.myweb.dao.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.dao.mybatis.MyFrameWorkMapper;
import com.myweb.dao.mybatis.mapper.*;
import com.myweb.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("frameWorkDao")
public class FrameWorkDaoImpl implements FrameWorkDao {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TableinfoMapper tableinfoMapper;

    @Autowired
    private ShuxingMapper shuxingMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private CaijiMapper caijiMapper;

    @Autowired
    private FuwuMapper fuwuMapper;

    @Autowired
    private MyFrameWorkMapper myFrameWorkMapper;

    @Override
    public List<User> findUsersByUsernameAndPassword(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<Menu> findMenusByParentAndRole(int parent, String role) {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andParentEqualTo(parent);
        return myFrameWorkMapper.queryByParentAndRole(parent, role);
    }

    @Override
    public long totalLaoren() {
        return laorenMapper.countByExample(null);
    }

    @Override
    public long totalCaiji() {
        return caijiMapper.countByExample(null);
    }

    @Override
    public long totalFuwu(String fuwutype) {
        FuwuExample fuwuExample = new FuwuExample();
        fuwuExample.createCriteria().andFuwutypeEqualTo(fuwutype);
        return fuwuMapper.countByExample(fuwuExample);

    }

    @Override
    public List<Tableinfo> findTableinfosByDisable(String tablename, Integer tabledisable, Integer modaldisable) {
        TableinfoExample tableinfoExample = new TableinfoExample();
        if(tabledisable != null && tabledisable == 0){
            tableinfoExample.createCriteria().andTablenameEqualTo(tablename).andTabledisableEqualTo(0);
        }else{
            tableinfoExample.createCriteria().andTablenameEqualTo(tablename).andModaldisableEqualTo(0);
        }
        tableinfoExample.setOrderByClause("shunxu");
        return tableinfoMapper.selectByExample(tableinfoExample);
    }

    @Override
    public List<Shuxing> findShuxingsByName(String name) {
        ShuxingExample shuxingExample = new ShuxingExample();
        shuxingExample.createCriteria().andNameEqualTo(name);
        shuxingExample.setOrderByClause("shunxu");
        return shuxingMapper.selectByExample(shuxingExample);
    }

}
