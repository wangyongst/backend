package com.myweb.dao;

import com.myweb.pojo.Password;
import com.myweb.pojo.Platform;
import com.myweb.pojo.User;
import com.myweb.pojo.Video;

import java.util.List;

public interface FrameWorkDao {

    List<User> findUserByUsernameAndPassword(String username, String password);

    public void saveVideo(Video video);

    public List<Video> findVideoByUrl(String url);

    public List<Video> findVideoByHome(Integer home);

    public List<Password> findPasswordByPassword(String password);

    public List<Platform> findPlatformByUse(Integer use);

    public List<Platform> findPlatformByUseNot(Integer use);

    public Platform findPlatformById(Integer id);

}
