package com.myweb.dao.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.dao.jpa.hibernate.PasswordRepository;
import com.myweb.dao.jpa.hibernate.PlatformRepository;
import com.myweb.dao.jpa.hibernate.UserRepository;
import com.myweb.dao.jpa.hibernate.VideoRepository;
import com.myweb.pojo.Password;
import com.myweb.pojo.Platform;
import com.myweb.pojo.User;
import com.myweb.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("frameWorkDao")
public class FrameWorkDaoImpl implements FrameWorkDao {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private PasswordRepository passwordRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Override
    public void saveVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public List<Video> findVideoByUrl(String url) {
        return videoRepository.findByUrl(url);
    }

    @Override
    public List<Video> findVideoByHome(Integer home) {
        return videoRepository.findByHome(1);
    }

    @Override
    public List<Password> findPasswordByPassword(String password) {
        return passwordRepository.findByPassword(password);
    }

    @Override
    public List<Platform> findPlatformByUseNot(Integer use) {
        return platformRepository.findByUseNot(use);
    }

    @Override
    public List<Platform> findPlatformByUse(Integer use) {
        return platformRepository.findByUse(use);
    }

    @Override
    public Platform findPlatformById(Integer id) {
        return platformRepository.findOne(id);
    }

    @Override
    public List<User> findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

}
