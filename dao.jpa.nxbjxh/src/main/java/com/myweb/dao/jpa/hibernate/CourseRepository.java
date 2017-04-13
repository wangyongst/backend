package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Course.class, idClass = Integer.class)
public interface CourseRepository extends JpaRepository<Course,Integer> {


}