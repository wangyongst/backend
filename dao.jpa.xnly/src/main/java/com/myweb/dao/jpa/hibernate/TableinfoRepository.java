package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Shuxing;
import com.myweb.pojo.Tableinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Tableinfo.class, idClass = Integer.class)
public interface TableinfoRepository extends JpaRepository <Tableinfo,Integer>{

}