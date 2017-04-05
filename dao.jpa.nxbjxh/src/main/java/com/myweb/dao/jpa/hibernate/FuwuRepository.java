package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Caiji;
import com.myweb.pojo.Fuwu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Fuwu.class, idClass = Integer.class)
public interface FuwuRepository extends JpaRepository <Fuwu,Integer>{

}