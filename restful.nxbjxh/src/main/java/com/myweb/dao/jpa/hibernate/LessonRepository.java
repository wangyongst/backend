package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Lesson.class, idClass = Integer.class)
public interface
LessonRepository extends JpaRepository<Lesson,Integer> {

    public List<Lesson> findByCourse(int course);

}