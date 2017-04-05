package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Caiji;
import com.myweb.pojo.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Caiji.class, idClass = Integer.class)
public interface CaijiRepository extends JpaRepository <Caiji,Integer> {

}