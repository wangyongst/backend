package com.myweb.dao.impl;

import com.myweb.dao.XiTongDao;
import com.myweb.dao.mybatis.mapper.JiashuMapper;
import com.myweb.dao.mybatis.mapper.LaorenMapper;
import com.myweb.dao.mybatis.mapper.UserMapper;
import com.myweb.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("xiTongDao")
public class XiTongDaoImpl implements XiTongDao {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LaorenMapper laorenMapper;

    @Autowired
    private JiashuMapper jiashuMapper;

    @Override
    public List<User> findUsersByUsernameNotSuper() {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameNotEqualTo("super");
        return userMapper.selectByExample(userExample);
    }

    public List<User> findUsersByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameNotEqualTo("super").andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<User> findUsersByUsernameAndIdNot(String username, int id) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username).andIdNotEqualTo(id);
        return userMapper.selectByExample(userExample);
    }

    @Override
    public List<Laoren> findLaorens(Laoren laoren) {
        LaorenExample laorenExample = new LaorenExample();
        LaorenExample.Criteria criteria = laorenExample.createCriteria();
        if(laoren.getType() != null){
            criteria.andTypeEqualTo(laoren.getType());
        }
        return laorenMapper.selectByExample(laorenExample);
    }

    @Override
    public List<Jiashu> findJiashus(Jiashu jiashu) {
        return jiashuMapper.selectByExample(null);
    }

    @Override
    public int saveJiashu(Jiashu jiashu) {
        return jiashuMapper.insert(jiashu);
    }


    @Override

    public int updateJiashuById(Jiashu jiashu) {
        return jiashuMapper.updateByPrimaryKeySelective(jiashu);
    }

    @Override

    public int deleteJiashuById(int id) {
        return jiashuMapper.deleteByPrimaryKey(id);
    }


    @Override
    public Laoren getLaorenById(int id) {
        return laorenMapper.selectByPrimaryKey(id);
    }

    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }


    @Override
    public Jiashu getJiashuById(int id) {
        return jiashuMapper.selectByPrimaryKey(id);
    }

    @Override

    public int saveLaoren(Laoren laoren) {
        return laorenMapper.insert(laoren);
    }

    @Override
    public int updateLaorenById(Laoren laoren) {
        return laorenMapper.updateByPrimaryKeySelective(laoren);
    }

    @Override
    public int updateLaorenTypeById(int type, int id) {
        Laoren laoren = new Laoren();
        laoren.setId(id);
        laoren.setType(type);
        return laorenMapper.updateByPrimaryKeySelective(laoren);
    }

    @Override

    public int saveUser(User user) {
        return userMapper.insert(user);

    }

    @Override

    public int updateUserById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override

    public int deleteLaorenById(int id) {
        return laorenMapper.deleteByPrimaryKey(id);
    }

    @Override

    public int deleteUserById(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
