package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Courserecord;
import com.myweb.pojo.Lessonrecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Courserecord.class, idClass = Integer.class)
public interface CourserecordRepository extends JpaRepository<Courserecord,Integer> {

    public List<Courserecord> findByCourseAndUser(int course,int user);

    public List<Courserecord> findByUser(int user);
}