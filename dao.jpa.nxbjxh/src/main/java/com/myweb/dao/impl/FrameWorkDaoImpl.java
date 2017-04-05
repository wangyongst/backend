package com.myweb.dao.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.dao.jpa.hibernate.*;
import com.myweb.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("frameWorkDao")
public class FrameWorkDaoImpl implements FrameWorkDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findUsersByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
