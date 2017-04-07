package com.myweb.service.impl;

import com.myweb.dao.jpa.hibernate.ParamRepository;
import com.myweb.dao.jpa.hibernate.UserRepository;
import com.myweb.pojo.Param;
import com.myweb.pojo.User;
import com.myweb.service.FrameWorkService;
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

@Service("frameWorkService")
@Transactional(value = "myTM", readOnly = true)
public class FrameWorkServiceImpl implements FrameWorkService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParamRepository paramRepository;

    @Override
    public Result login(HttpSession session, User user) {
        List<User> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        Result result = new Result();
        if (ServiceUtils.isReseachListOK(result, userList)) {
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
    public Result register(HttpSession session, User user) {
        user.setTime(DateUtils.getCurrentTimeSecond());
        Result result = new Result();
        if(ServiceUtils.isBlankValue(result,user.getName())){
            result.setMessage("注册失败，你输入的的姓名不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getIdentity())){
            result.setMessage("注册失败，你输入的的身份证号码不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getPhone())){
            result.setMessage("注册失败，你输入的的联系电话不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getUsername())){
            result.setMessage("注册失败，你输入的的用户名不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getPassword())){
            result.setMessage("注册失败，你输入的的密码不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getDepartment())){
            result.setMessage("注册失败，你输入的的科室不能为空！");
            return result;
        }
        if(ServiceUtils.isReseachListOK(result,userRepository.findByUsername(user.getUsername()))){
            result.setMessage("注册失败，你的输入的用户名已经被注册！");
            result.setStatus(2);
            return result;
        }
        if(ServiceUtils.isReseachListOK(result,userRepository.findByIdentity(user.getIdentity()))){
            result.setMessage("注册失败，你的输入的身份证号码已经被注册！");
            result.setStatus(2);
            return result;
        }
        if(userRepository.save(user) != null) {
            return ServiceUtils.isCRUDOK("create", new Result(), 1);
        }else{
            return ServiceUtils.isCRUDOK("create", new Result(), 0);
        }
    }


    @Override
    public Result forget(HttpSession session, User user) {
        Result result = new Result();
        if(ServiceUtils.isBlankValue(result,user.getName())){
            result.setMessage("注册失败，你输入的的姓名不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getIdentity())){
            result.setMessage("注册失败，你输入的的身份证号码不能为空！");
            return result;
        }
        if(ServiceUtils.isBlankValue(result,user.getUsername())){
            result.setMessage("注册失败，你输入的的用户名不能为空！");
            return result;
        }
        ServiceUtils.isReseachListOK(result,userRepository.findByNameAndIdentityAndUsername(user.getName(),user.getIdentity(),user.getUsername()));
        return result;

    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result update(HttpSession session, User user) {
        User updateUser = userRepository.findOne(user.getId());
        if (updateUser != null) {
            ServiceUtils.copyPropertiesIgnoreNull(user,updateUser);
            userRepository.save(updateUser);
            return ServiceUtils.isCRUDOK("update", new Result(), 1);
        }else{
            return ServiceUtils.isCRUDOK("update", new Result(), 0);
        }
    }

    @Override
    public Result listParams(HttpSession session, Param param) {
        Result result = new Result();
        if (param.getName() == null) {
            if (ServiceUtils.isReseachListOK(result, paramRepository.findAll())) {
            }
            return result;
        }else{
           return new Result();
        }
    }
}
