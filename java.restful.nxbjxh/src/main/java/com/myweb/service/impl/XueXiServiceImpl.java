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
import java.util.*;

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

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private BandRepository bandRepository;

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
        User user = (User)session.getAttribute("user");
        map.put("titles",paramRepository.findByName("title"));
        Unit myunit = unitRepository.findByName(user.getUnit()).get(0);
        map.put("myunit",myunit.getId());
        map.put("mynuittype",myunit.getType());
        List<Unit> myunits = unitRepository.findByPidAndType(myunit.getPid(),myunit.getType());
        map.put("myunits",myunits);
        if(myunit.getType() == 3){
            Unit myquxian = unitRepository.findOne(myunits.get(0).getPid());
            map.put("myquxian",myquxian.getId());
            List<Unit> myquxians = unitRepository.findByPidAndType(myquxian.getPid(),myquxian.getType());
            map.put("myquxians",myquxians);
            if(myquxian.getType() == 6){
                Unit myshi = unitRepository.findOne(myquxians.get(0).getPid());
                map.put("myshi",myshi.getId());
                List<Unit> myshis = unitRepository.findByPidAndType(myshi.getPid(),myshi.getType());
                map.put("myshis",myshis);
            }
        }else if(myunit.getType() == 2){
            Unit myshi = unitRepository.findOne(myunits.get(0).getPid());
            map.put("myshi",myshi.getId());
            List<Unit> myshis = unitRepository.findByPidAndType(myshi.getPid(),myshi.getType());
            map.put("myshis",myshis);
        }
        return map;
    }

    @Override
    public Map makeHome(HttpSession session,Map map) {
        map.put("courses",courseRepository.findAll());
        return map;
    }

    @Override
    public Map makeLessons(HttpSession session, Course course, Map map) {
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
            courserecord.setStatus(1);
            courserecordRepository.save(courserecord);
        }
        return map;
    }

    @Override
    @Transactional(value = "myTM", propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
    public Result postBand(HttpSession session, Number number,Integer course) {
        Result result = new Result();
        User user = (User) session.getAttribute("user");
        if(StringUtils.isBlank(number.getNumber()) || StringUtils.isBlank(number.getPassword())){
            result.setStatus(2);
            result.setMessage("申请学分失败，你的输入的学习卡号或学习卡密码为空，请重新输入！");
            return result;
        }else if (!ServiceUtils.isReseachListOK(result, numberRepository.findByNumberAndPassword(number.getNumber(),number.getPassword()))) {
            result.setMessage("申请学分失败，你的输入的学习卡号不存在或密码不正确，请重新输入！");
            result.setStatus(2);
            return result;
        }else if (ServiceUtils.isReseachListOK(result, bandRepository.findByNumber(number.getNumber()))) {
           result.setMessage("申请学分失败，你的输入的学习卡号已经被绑定，不能重复使用！");
            result.setStatus(2);
            return result;
       }else {
            Band band = new Band();
            band.setCourse(course);
            band.setUser(user.getId());
            band.setNumber(number.getNumber());
            band.setTime(DateUtils.getCurrentTimeSecond());
            bandRepository.save(band);
            List<Courserecord> courserecordList = courserecordRepository.findByCourseAndUser(course,user.getId());
            for (Courserecord cc:courserecordList) {
                cc.setStatus(3);
                courserecordRepository.save(cc);
            }
            result.setMessage("申请学分成功，你已经获得学分，请在我的学分中查看具体信息！");
            result.setStatus(1);
            return result;
        }
    }

    @Override
    public Result getTest(HttpSession session, Lesson lesson,Test test) {
        Result result = new Result();
        if(ServiceUtils.isReseachListOK(result,randomTopic(testRepository.findByLessonAndTestOrderByOrdAsc(lesson.getId(),test.getTest()),10))){
            return result;
        }else {
            result.setStatus(2);
            result.setMessage("在线考试题获取失败，请联系管理员！");
            return result;
        }
    }

    // 从List中随机出count个对象
    private List<Test> randomTopic(List<Test> list, int count) {
        // 创建一个长度为count(count<=list)的数组,用于存随机数
        if(list.size() < count) count = list.size();
        int[] a = new int[count];
        // 利于此数组产生随机数
        int[] b = new int[list.size()];
        int size = list.size();

        // 取样填充至数组a满
        for (int i = 0; i < count; i++) {
            int num = (int) (Math.random() * size); // [0,size)
            int where = -1;
            for (int j = 0; j < b.length; j++) {
                if (b[j] != -1) {
                    where++;
                    if (where == num) {
                        b[j] = -1;
                        a[i] = j;
                    }
                }
            }
            size = size - 1;
        }
        // a填满后 将数据加载到rslist
        List<Test> rslist = new ArrayList<Test>();
        for (int i = 0; i < count; i++) {
            Test df = (Test) list.get(a[i]);
            rslist.add(df);
        }
        Collections.sort(rslist);
        return rslist;
    }

    @Override
    public Result postTest(HttpSession session,Lesson lesson, String yes) {
        List<Test> notRight = new ArrayList<Test>();
        User user = (User)session.getAttribute("user");
        Result result = new Result();
        if(lesson.getId() == null || StringUtils.isBlank(yes) || yes.split(",").length < 10){
            result.setStatus(2);
            result.setMessage("你还没有做完考试题，请先完成全部题目后再交卷！");
            return result;
        }
        String[] yeses = yes.split(",");
        for(String ye : yeses){
            String[] ans = ye.split("=");
            List<Test> yesorno = testRepository.findByIdAndYes(Integer.parseInt(ans[1]),1);
            if(yesorno == null || yesorno.size() == 0){
                notRight.add(testRepository.findOne(Integer.parseInt(ans[0])));
            }
        }
        if(notRight.size() > 0){
            result.setStatus(9);
            result.setMessage("你的考试成绩不合格，共答错"+notRight.size()+"题，有以下题目答题错误！");
            result.setData(notRight);
            return result;
        }
        lesson = lessonRepository.findOne(lesson.getId());
        Lessonrecord lessonrecord = lessonrecordRepository.findByLessonAndUser(lesson.getId(),user.getId()).get(0);
        lessonrecord.setStatus(1);
        lessonrecord.setEndtime(DateUtils.getCurrentTimeSecond());
        lessonrecordRepository.save(lessonrecord);
        if(lessonrecordRepository.findByCourseAndUserAndStatus(lesson.getCourse(),user.getId(),1).size() == lessonRepository.findByCourse(lesson.getCourse()).size()){
            Courserecord courserecord = courserecordRepository.findByCourseAndUser(lesson.getCourse(),user.getId()).get(0);
            courserecord.setEndtime(DateUtils.getCurrentTimeSecond());
            courserecord.setStatus(2);
            courserecordRepository.save(courserecord);
            result.setStatus(10);
        }
        result.setMessage("恭喜你，你的本课件考试成绩合格，请继续学习其它课件！");
        return result;
    }

    @Override
    public List<XueFenVo> getXueFen(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return myRepository.queryXuefenByUser(user.getId());
    }

    @Override
    public List<XueXiVo> getXueXi(HttpSession session,Lessonrecord lessonrecord) {
        User user = (User) session.getAttribute("user");
        return myRepository.queryXuexiByUserAndCourse(user.getId(),lessonrecord.getCourse());
    }
}
