package com.myweb.service.impl;

import com.myweb.dao.XiTongDao;
import com.myweb.pojo.Jiashu;
import com.myweb.pojo.Laoren;
import com.myweb.pojo.User;
import com.myweb.service.XiTongService;
import com.myweb.util.DateUtils;
import com.myweb.util.Page;
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
import java.util.TreeSet;

@Service("xiTongService")
@Transactional(value = "myTM", readOnly = true)
public class XiTongServiceImpl implements XiTongService {

    @Autowired
    private XiTongDao xiTongDao;

    @Override
    public List<User> listUsers(HttpSession session, User user, Page page) {
        return xiTongDao.findUsersByUsernameNotSuper();
    }

    @Override
    public List<Laoren> listLaorens(HttpSession session, Laoren laoren, Page page) {
        return xiTongDao.findLaorens(laoren);
    }

    @Override
    public List<Jiashu> listJiashus(HttpSession session, Jiashu jiashu, Page page) {
        return xiTongDao.findJiashus(jiashu);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createJiashu(HttpSession session, Jiashu jiashu) {
        User create = (User) session.getAttribute("user");
        jiashu.setCreateuser(create.getId());
        jiashu.setCreateusername(create.getName());
        jiashu.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), xiTongDao.saveJiashu(jiashu));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateJiashu(HttpSession session, Jiashu jiashu) {
        return ServiceUtils.isCRUDOK("update", new Result(), xiTongDao.updateJiashuById(jiashu));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaorenTypebyId(HttpSession session, String id, String type) {
        Result result = new Result();
        int count = 0;
        if (ServiceUtils.isIds(result, id)) {
            TreeSet<String> idSet = (TreeSet<String>) result.getData();
            for (String ids : idSet) {
                if (StringUtils.isNotBlank(ids)) {
                    count += xiTongDao.updateLaorenTypeById(Integer.parseInt(type), Integer.parseInt(ids));
                }
            }
            ServiceUtils.isCRUDOK("update", result, count);
        }
        return result;
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isCRUDOK("delete", result, xiTongDao.deleteJiashuById((Integer) result.getData()));
        }
        return result;
    }


    @Override
    public Result getLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, xiTongDao.getLaorenById((Integer) result.getData()));
        }
        return result;
    }

    public Result getUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, xiTongDao.getUserById((Integer) result.getData()));
        }
        return result;
    }

    @Override
    public Result getJiashu(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            ServiceUtils.isReseachOK(result, xiTongDao.getJiashuById((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createLaoren(HttpSession session, Laoren laoren) {
        User create = (User) session.getAttribute("user");
        laoren.setCreateuser(create.getId());
        laoren.setCreateusername(create.getName());
        laoren.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), xiTongDao.saveLaoren(laoren));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateLaoren(HttpSession session, Laoren laoren) {
        return ServiceUtils.isCRUDOK("update", new Result(), xiTongDao.updateLaorenById(laoren));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        if (ServiceUtils.isNotUnique(result, xiTongDao.findUsersByUsername(user.getUsername()).size())) {
            return result;
        }
        User create = (User) session.getAttribute("user");
        user.setCreateuser(create.getId());
        user.setCreateusername(create.getName());
        user.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), xiTongDao.saveUser(user));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateUser(HttpSession session, User user) {
        Result result = new Result();
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            return result;
        }
        if (ServiceUtils.isNotUnique(result, xiTongDao.findUsersByUsernameAndIdNot(user.getUsername(), user.getId()).size())) {
            return result;
        }
        return ServiceUtils.isCRUDOK("update", new Result(), xiTongDao.updateUserById(user));
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteLaoren(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            return ServiceUtils.isCRUDOK("delete", result, xiTongDao.deleteLaorenById((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteUser(HttpSession session, String id) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, id)) {
            return ServiceUtils.isCRUDOK("delete", result, xiTongDao.deleteUserById((Integer) result.getData()));
        }
        return result;
    }
}
