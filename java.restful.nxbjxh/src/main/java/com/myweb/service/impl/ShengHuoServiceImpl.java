package com.myweb.service.impl;

import com.myweb.dao.ShengHuoDao;
import com.myweb.pojo.Fuwu;
import com.myweb.pojo.User;
import com.myweb.service.ShengHuoService;
import com.myweb.util.DateUtils;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service("shengHuoService")
@Transactional(value = "myTM", readOnly = true)
public class ShengHuoServiceImpl implements ShengHuoService {

    @Autowired
    private ShengHuoDao shengHuoDao;


    @Override
    public Result getFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, ids)) {
            ServiceUtils.isReseachOK(result, shengHuoDao.getFuwuById((Integer) result.getData()));
        }
        return result;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result createFuwu(HttpSession session, Fuwu fuwu) {
        Result result = new Result();
        User create = (User) session.getAttribute("user");
        fuwu.setCreateuser(create.getId());
        fuwu.setCreateusername(create.getName());
        fuwu.setCreatetime(DateUtils.getCurrentTimeSecond());
        return ServiceUtils.isCRUDOK("create", new Result(), shengHuoDao.saveFuwu(fuwu));
    }


    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateFuwu(HttpSession session, Fuwu fuwu) {
        return ServiceUtils.isCRUDOK("update", new Result(), shengHuoDao.updateFuwuById(fuwu));
    }

    @Override
    public List<Fuwu> listFuwus(HttpSession session, Fuwu fuwu) {
        return shengHuoDao.findFuwus(fuwu);
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result deleteFuwu(HttpSession session, String ids) {
        Result result = new Result();
        if (ServiceUtils.isOnlyOneId(result, ids)) {
            return ServiceUtils.isCRUDOK("delete", result, shengHuoDao.deleteFuwuById((Integer) result.getData()));
        }
        return result;
    }
}
