package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Zhongjiang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Zhongjiang.class, idClass = Integer.class)
public interface ZhongjiangRepository extends JpaRepository<Zhongjiang,Integer> {

}