package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Lessonrecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Lessonrecord.class, idClass = Integer.class)
public interface LessonrecordRepository extends JpaRepository<Lessonrecord,Integer> {

    public List<Lessonrecord> findByLessonAndUser(int lesson, int user);

    public List<Lessonrecord> findByCourseAndUserAndStatus(int course, int user, int status);

    public List<Lessonrecord> findByLessonAndUserAndStatus(int lesson, int user, int status);
}