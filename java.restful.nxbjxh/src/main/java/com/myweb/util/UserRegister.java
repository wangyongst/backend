package com.myweb.util;

import com.myweb.pojo.User;

/**
 * Created by BHWL on 2017-04-11.
 */
public class UserRegister {

    public Result isRegisterOK(Result result,User user){
        if (ServiceUtils.isBlankValue(result, user.getName())) {
            result.setStatus(5);
            result.setMessage("注册失败，你输入的的姓名不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getIdentity())) {
            result.setMessage("注册失败，你输入的的身份证号码不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getPhone())) {
            result.setMessage("注册失败，你输入的的联系电话不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getUsername())) {
            result.setMessage("注册失败，你输入的的用户名不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getPassword())) {
            result.setMessage("注册失败，你输入的的密码不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getDepartment())) {
            result.setMessage("注册失败，你输入的的科室不能为空！");
            return result;
        }else{
            return result;
        }
    }


}
