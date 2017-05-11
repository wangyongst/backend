package com.myweb.service.impl;

import com.myweb.dao.jpa.MyRepository;
import com.myweb.dao.jpa.hibernate.*;
import com.myweb.pojo.*;
import com.myweb.pojo.Number;
import com.myweb.service.XueXiService;
import com.myweb.util.DateUtils;
import com.myweb.util.Result;
import com.myweb.util.ServiceUtils;
import com.myweb.vo.XueFenVo;
import com.myweb.vo.XueXiVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
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

    @Autowired
    private  TestRepository testRepository;

    @Autowired
    private MyRepository myRepository;

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result updateUser(HttpSession session, User user) {
        Result result = new Result();
        result = UserRegister.isUpdateOK(result,user);
        if(result.getStatus() != 1) return result;
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
        User user = (User)session.getAttribute("user");
        Lesson currentLesson = lessonRepository.findOne(lesson.getId());
        map.put("currentLesson",currentLesson);
        map.put("currentCourse",courseRepository.findOne(currentLesson.getCourse()));
        List lessonrordList = lessonrecordRepository.findByLessonAndUser(currentLesson.getId(),user.getId());
        if(lessonrordList == null || lessonrordList.size() ==0){
            Lessonrecord lessonrecord = new Lessonrecord();
            lessonrecord.setLesson(currentLesson.getId());
            lessonrecord.setCourse(currentLesson.getCourse());
            lessonrecord.setBegintime(DateUtils.getCurrentTimeSecond());
            lessonrecord.setStatus(0);
            lessonrecord.setUser(user.getId());
            lessonrecordRepository.save(lessonrecord);
        }
        List courserecordList = courserecordRepository.findByCourseAndUser(currentLesson.getCourse(),user.getId());
        if(courserecordList == null || courserecordList.size() == 0 ){
            Courserecord courserecord = new Courserecord();
            courserecord.setCourse(currentLesson.getCourse());
            courserecord.setBegintime(DateUtils.getCurrentTimeSecond());
            courserecord.setUser(user.getId());
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
        }else if (!ServiceUtils.isReseachListOK(result, numberRepository.findByNumber(number.getNumber()))) {
            result.setMessage("绑定失败，你的输入的学习卡号不存在，请重新输入！");
            result.setStatus(2);
            return result;
//        }else if (ServiceUtils.isReseachListOK(result, userRepository.findByNumber(number.getNumber()))) {
//            result.setMessage("绑定失败，你的输入的学习卡号已经被绑定，不能重复使用！");
//            result.setStatus(2);
//            return result;
       } else {
            User user = (User) session.getAttribute("user");
            //user.setNumber(number.getNumber());
            userRepository.save(user);
            session.setAttribute("user", userRepository.findOne(user.getId()));
            return ServiceUtils.isCRUDOK("update", new Result(), 1);
        }
    }

    @Override
    public Result getTest(HttpSession session, Lesson lesson,Test test) {
        Result result = new Result();
        if(ServiceUtils.isReseachListOK(result,testRepository.findByLessonAndTestOrderByOrdAsc(lesson.getId(),test.getTest()))){
            return result;
        }else {
            result.setStatus(2);
            result.setMessage("在线考试题获取失败，请联系管理员！");
            return result;
        }
    }

    @Override
    public Result postTest(HttpSession session,Lesson lesson, String yes) {
        User user = (User)session.getAttribute("user");
        Result result = new Result();
        if(lesson.getId() == null || StringUtils.isBlank(yes)){
            result.setStatus(2);
            result.setMessage("你还没有做题，请先完成题目后再交卷！");
            return result;
        }
        lesson = lessonRepository.findOne(lesson.getId());
        String[] yeses = yes.split(",");
        List<Test> testList = testRepository.findByLessonAndYes(lesson.getId(),1);
        if(yeses.length != testList.size()){
            result.setStatus(2);
            result.setMessage("考试成绩不合格，请重新修改你的答案！");
            return result;
        }
        for(Test test : testList){
            if(!Arrays.asList(yeses).contains(test.getId()+"")){
                result.setStatus(2);
                result.setMessage("考试成绩不合格，请重新修改你的答案！");
                return result;
            }
        }
        Lessonrecord lessonrecord = lessonrecordRepository.findByLessonAndUser(lesson.getId(),user.getId()).get(0);
        lessonrecord.setStatus(1);
        lessonrecord.setEndtime(DateUtils.getCurrentTimeSecond());
        lessonrecordRepository.save(lessonrecord);
        if(lessonrecordRepository.findByCourseAndUserAndStatus(lesson.getCourse(),user.getId(),1).size() == lessonRepository.findByCourse(lesson.getCourse()).size()){
            Courserecord courserecord = courserecordRepository.findByCourseAndUser(lesson.getCourse(),user.getId()).get(0);
            courserecord.setEndtime(DateUtils.getCurrentTimeSecond());
            courserecordRepository.save(courserecord);
        }
        result.setMessage("恭喜你，你的本课程考试成绩合格！");
        return result;
    }

    @Override
    public List<XueFenVo> getXueFen(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return myRepository.queryXuefenByUser(user.getId());
    }

    @Override
    public List<XueXiVo> getXueXi(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return myRepository.queryXuexiByUser(user.getId());
    }
}
