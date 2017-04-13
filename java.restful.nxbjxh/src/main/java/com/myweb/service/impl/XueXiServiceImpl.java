package com.myweb.service.impl;

import com.myweb.dao.jpa.hibernate.*;
import com.myweb.pojo.*;
import com.myweb.pojo.Number;
import com.myweb.service.XueXiService;
import com.myweb.util.DateUtils;
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
import java.util.Map;

@Service("xueXiService")
@Transactional(value = "myTM", readOnly = true)
public class XueXiServiceImpl implements XueXiService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParamRepository paramRepository;

    @Autowired
    private LessonrecordRepository lessonrecordRepository;

    @Autowired
    private CourserecordRepository courserecordRepository;

    @Autowired
    private  NumberRepository numberRepository;

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateUser(HttpSession session, User user) {
        Result result = new Result();
        result = UserRegister.isUpdateOK(result,user);
        if(result.getStatus() != 1) return result;
        if (ServiceUtils.isReseachListOK(result, userRepository.findByUsernameAndIdNot(user.getUsername(), user.getId()))) {
            result.setMessage("修改失败，你的输入的用户名已经被注册！");
            result.setStatus(2);
            return result;
        }
        if (ServiceUtils.isReseachListOK(result, userRepository.findByIdentityAndIdNot(user.getIdentity(), user.getId()))) {
            result.setMessage("修改失败，你的输入的身份证号码已经被注册！");
            result.setStatus(2);
            return result;
        }
        User updateUser = userRepository.findOne(user.getId());
        if (updateUser != null) {
            ServiceUtils.copyPropertiesIgnoreNull(user, updateUser);
            userRepository.save(updateUser);
            session.setAttribute("user", userRepository.findOne(user.getId()));
            return ServiceUtils.isCRUDOK("update", new Result(), 1);
        } else {
            return ServiceUtils.isCRUDOK("update", new Result(), 0);
        }
    }

    @Override
    public Map update(HttpSession session, Map map) {
        map.put("titles",paramRepository.findByName("title"));
        return map;
    }

    @Override
    public Map makeHome(HttpSession session, Course course, Map map) {
        if(course.getId() == null || course.getId() == 0) course.setId(1);
        map.put("max",courseRepository.count());
        map.put("total",courseRepository.findAll());
        map.put("currentCourse",courseRepository.findOne(course.getId()));
        map.put("lessons",lessonRepository.findByCourse(course.getId()));
        return map;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Map makeLesson(HttpSession session, Lesson lesson, Map map) {
        Lesson currentLesson = lessonRepository.findOne(lesson.getId());
        map.put("currentLesson",currentLesson);
        map.put("currentCourse",courseRepository.findOne(currentLesson.getCourse()));
        List lessonrordList = lessonrecordRepository.findByLesson(currentLesson.getId());
        if(lessonrordList == null || lessonrordList.size() ==0){
            Lessonrecord lessonrecord = new Lessonrecord();
            lessonrecord.setLesson(currentLesson.getId());
            lessonrecord.setBegintime(DateUtils.getCurrentTimeSecond());
            lessonrecord.setStatus(0);
            lessonrecordRepository.save(lessonrecord);
        }
        List courserecordList = courserecordRepository.findByCourse(currentLesson.getCourse());
        if(courserecordList == null || courserecordList.size() == 0 ){
            Courserecord courserecord = new Courserecord();
            courserecord.setCourse(currentLesson.getCourse());
            courserecord.setBegintime(DateUtils.getCurrentTimeSecond());
            courserecordRepository.save(courserecord);
        }
        return map;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result bangding(HttpSession session, Number number) {
        Result result = new Result();
        if(StringUtils.isBlank(number.getNumber())){
            result.setStatus(2);
            result.setMessage("绑定失败，你的输入的学习卡号为空，请重新输入！");
            return result;
        }
        if (ServiceUtils.isReseachListOK(result, numberRepository.findByNumber(number.getNumber()))) {
            result.setMessage("绑定失败，你的输入的学习卡号不存在，请重新输入！");
            result.setStatus(2);
            return result;
        }
        if (ServiceUtils.isReseachListOK(result, userRepository.findByNumber(number.getNumber()))) {
            result.setMessage("绑定失败，你的输入的学习卡号已经被绑定，不能重复使用！");
            result.setStatus(2);
            return result;
        }
        User user = (User)session.getAttribute("user");
        if (user != null) {
            user.setNumber(number.getNumber());
            userRepository.save(user);
            session.setAttribute("user", userRepository.findOne(user.getId()));
            return ServiceUtils.isCRUDOK("update", new Result(), 1);
        } else {
            return ServiceUtils.isCRUDOK("update", new Result(), 0);
        }
    }

}
