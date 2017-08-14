package com.myweb.dao.jpa.hibernate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Number.class, idClass = Integer.class)
public interface NumberRepository extends JpaRepository<com.myweb.pojo.Number,Integer> {

    public List<Number> findByNumberAndPassword(String number, String passwod);
}