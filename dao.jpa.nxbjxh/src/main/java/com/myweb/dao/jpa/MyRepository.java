package com.myweb.dao.jpa;

import com.myweb.pojo.Course;
import com.myweb.pojo.Test;
import com.myweb.pojo.User;
import com.myweb.vo.XueFenVo;
import com.myweb.vo.XueXiVo;
import org.hibernate.annotations.Target;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BHWL on 2017-04-18.
 */
@Repository
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface MyRepository{
    @Query("select new com.myweb.vo.XueFenVo(b.id,b.name,a.begintime,a.endtime,b.score,b.year,a.status) from Courserecord a ,Course b where a.course = b.id and a.user = ?1")
    public List<XueFenVo> queryXuefenByUser(int user);

    @Query("select new com.myweb.vo.XueXiVo(l.id,s.name,l.begintime,l.endtime,l.status,r.name) from Lessonrecord l,Courserecord c,Lesson s,Course r where l.user = ?1 and c.user = ?1 and l.course = c.course and (c.endtime = '' or c.endtime is null) and l.lesson = s.id and s.course = r.id")
    public List<XueXiVo> queryXuexiByUser(int user);
}
