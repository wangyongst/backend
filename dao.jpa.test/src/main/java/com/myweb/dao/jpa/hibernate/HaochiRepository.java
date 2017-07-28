package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Haochi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Haochi.class, idClass = Integer.class)
public interface HaochiRepository extends JpaRepository<Haochi, Integer> {

}