package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Lesson;
import com.myweb.pojo.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Param.class, idClass = Integer.class)
public interface ParamRepository extends JpaRepository<Param,Integer> {

    public List<Param> findByName(String name);

}