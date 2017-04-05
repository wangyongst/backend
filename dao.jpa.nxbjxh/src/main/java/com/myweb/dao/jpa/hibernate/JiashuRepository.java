package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Fuwu;
import com.myweb.pojo.Jiashu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Jiashu.class, idClass = Integer.class)
public interface JiashuRepository extends JpaRepository <Jiashu,Integer>{
}