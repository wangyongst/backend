package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Unit.class, idClass = Integer.class)
public interface UnitRepository extends JpaRepository<Unit, Integer> {

    public List<Unit> findByPidAndType(Integer pid,Integer type);

}