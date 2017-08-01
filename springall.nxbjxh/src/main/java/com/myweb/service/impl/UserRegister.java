package com.myweb.service.impl;

import com.myweb.pojo.User;
import com.framework.utils.Result;
import com.myweb.util.ServiceUtils;

import java.util.regex.Pattern;

/**
 * Created by BHWL on 2017-04-11.
 */
public class UserRegister {

    public static Result isRegisterOK(Result result, User user){
        return isAnyBlank(result,user,"注册用户");
    }

    public static Result isUpdateOK(Result result, User user){
        return isAnyBlank(result,user,"修改用户资料");
    }

    public static Result isAnyBlank(Result result,User user,String method){
        if (ServiceUtils.isBlankValue(result, user.getName())) {
            result.setMessage(method+"失败，你输入的的姓名不能为空！");
            return result;
        }
        if(!Pattern.matches("^[\\u4e00-\\u9fa5]{2,20}$",user.getName())){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的姓名不是一个姓名！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getIdentity())) {
            result.setMessage(method+"失败，你输入的身份证号码不能为空！");
            return result;
        }
        if(!Pattern.matches("^\\d{18}|\\d{15}|\\d{17}X$",user.getIdentity())){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的的身份证号码不是一个身份证号码！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getPhone())) {
            result.setMessage(method+"失败，你输入的的联系电话不能为空！");
            return result;
        }
        if(!Pattern.matches("^\\d{3}-\\d{7,8}|\\d{4}-\\d{7,8}$|\\d{11,12}$",user.getPhone())){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的的联系电话不是一个电话号码！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getPassword())) {
            result.setMessage(method+"失败，你输入的密码不能为空！");
            return result;
        }
        if(user.getPassword().length() < 6 || user.getPassword().length() > 22){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的密码长度不符合要求！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getUnit())) {
            result.setMessage(method+"失败，你输入的单位不能为空！");
            return result;
        }
        if(!Pattern.matches("^[\\u4e00-\\u9fa5]{1,20}$",user.getUnit())){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的单位不是汉字名称！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getDepartment())) {
            result.setMessage(method+"失败，你输入的科室不能为空！");
            return result;
        }
        if (ServiceUtils.isBlankValue(result, user.getTitle())) {
            result.setMessage(method+"失败，你输入的职称不能为空！");
            return result;
        }
        if(!Pattern.matches("^[\\u4e00-\\u9fa5]{1,20}$",user.getDepartment())){
            result.setStatus(2);
            result.setMessage(method+"失败，你输入的科室不是汉字名称！");
            return result;
        }
        else{
            return result;
        }
    }

}
