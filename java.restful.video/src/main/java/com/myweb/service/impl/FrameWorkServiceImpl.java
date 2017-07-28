package com.myweb.service.impl;

import com.myweb.dao.FrameWorkDao;
import com.myweb.pojo.Platform;
import com.myweb.pojo.User;
import com.myweb.pojo.Video;
import com.myweb.service.FrameWorkService;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private FrameWorkDao frameWorkDao;

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result playVideo(String platformid, String url, String password) {
        Result result = new Result();
        if(StringUtils.isBlank(platformid) || StringUtils.isBlank(url)){
            ServiceUtils.isBlank(result);
            return result;
        }else if(!url.contains("http")){
            ServiceUtils.isZero(result);
            return result;
        }
        Video video = new Video();
        video.setUrl(url);
        if (frameWorkDao.findVideoByUrl(url).size() == 0) {
            frameWorkDao.saveVideo(video);
        }
        ServiceUtils.isReseachListOK(result, frameWorkDao.findPasswordByPassword(password));
        Platform platform = frameWorkDao.findPlatformById(Integer.parseInt(platformid));
        result.setData(platform.getUrl() + url);
        return result;
    }

    @Override
    public Result listPlatform(HttpSession session) {
        Result result = new Result();
        ServiceUtils.isReseachListOK(result, frameWorkDao.findPlatformByUseNot(0));
        return result;
    }

    @Override
    public Result playDefaultVideo() {
        Result result = new Result();
        List<Platform> platformList = frameWorkDao.findPlatformByUse(2);
        ServiceUtils.isReseachListOK(result, platformList);
        List<Video> videoList = frameWorkDao.findVideoByHome(1);
        if (result.getStatus() == 7 || result.getStatus() == 1) ServiceUtils.isReseachListOK(result, videoList);
        if (result.getStatus() == 7 || result.getStatus() == 1) result.setData(platformList.get(0).getUrl()+videoList.get(0).getUrl());
        return result;
    }

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = frameWorkDao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }
}
