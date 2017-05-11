package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Band;
import com.myweb.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryDefinition(domainClass = Band.class, idClass = Integer.class)
public interface BandRepository extends JpaRepository<Band,Integer> {

}