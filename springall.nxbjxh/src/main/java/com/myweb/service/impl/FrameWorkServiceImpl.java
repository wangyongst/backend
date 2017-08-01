package com.myweb.service.impl;

import com.framework.utils.Result;
import com.myweb.dao.jpa.hibernate.ParamRepository;
import com.myweb.dao.jpa.hibernate.UnitRepository;
import com.myweb.dao.jpa.hibernate.UserRepository;
import com.myweb.pojo.Unit;
import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
import com.framework.utils.Datetime.DateUtils;
import com.framework.utils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParamRepository paramRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Override
    public Result login(HttpSession session, User user, String authcode) {
        Result result = new Result();
        if (!authcode.equals(session.getAttribute("verCode"))) {
            result.setStatus(2);
            result.setMessage("登录失败，你的验证码输入不正确！");
            return result;
        }
        List<User> userList = userRepository.findByIdentityAndPassword(user.getIdentity(), user.getPassword());
        if (ServiceUtils.isReseachListOK(result, userList)) {
            session.removeAttribute("user");
            session.setAttribute("user", userList.get(0));
        }
        return result;
    }


    public Result logout(HttpSession session) {
        session.removeAttribute("user");
        return new Result();
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result register(HttpSession session, User user, String authcode) {
        user.setTime(DateUtils.getCurrentTimeSecond());
        Result result = new Result();
        if (!authcode.equals(session.getAttribute("verCode"))) {
            result.setStatus(2);
            result.setMessage("注册失败，你的验证码输入不正确！");
            return result;
        }
        result = UserRegister.isRegisterOK(result, user);
        if (result.getStatus() != 1) return result;
        if (ServiceUtils.isReseachListOK(result, userRepository.findByIdentity(user.getIdentity()))) {
            result.setMessage("注册失败，你的输入的身份证号码已经被注册！");
            result.setStatus(2);
            return result;
        }
        if (userRepository.save(user) != null) {
            return ServiceUtils.isCRUDOK("create", new Result(), 1);
        } else {
            return ServiceUtils.isCRUDOK("create", new Result(), 0);
        }
    }

    @Override
    public Map regist(HttpSession session, Map map) {
        map.put("titles", paramRepository.findByName("title"));
        return map;
    }


    @Override
    public Result forget(HttpSession session, User user, String authcode) {
        Result result = new Result();
        if (!authcode.equals(session.getAttribute("verCode"))) {
            result.setStatus(2);
            result.setMessage("找回密码失败，你的验证码输入不正确！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getName())) {
            result.setMessage("找回密码失败，你输入的的姓名不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getIdentity())) {
            result.setMessage("找回密码失败，你输入的的身份证号码不能为空！");
            return result;
        } else {
            ServiceUtils.isReseachListOK(result, userRepository.findByNameAndIdentity(user.getName(), user.getIdentity()));
            return result;
        }
    }

    @Override
    public Result unit(HttpSession session, Unit unit) {
        Result result = new Result();
        if (unit.getType() != null && unit.getPid() != null && unit.getType() == 1) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("1");
        }else  if (unit.getType() != null && unit.getPid() != null && unit.getType() == 2) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("2");
        }else  if (unit.getType() != null && unit.getPid() != null && unit.getType() == 3) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("3");
        }else  if (unit.getType() != null && unit.getPid() != null && unit.getType() == 4) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("4");
        }else  if (unit.getType() != null && unit.getPid() != null && unit.getType() == 5) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("5");
        }else  if (unit.getType() != null && unit.getPid() != null && unit.getType() == 6) {
            ServiceUtils.isReseachListOK(result, unitRepository.findByPidAndType(unit.getPid(), unit.getType()));
            result.setMessage("6");
        }
        return result;
    }


}
