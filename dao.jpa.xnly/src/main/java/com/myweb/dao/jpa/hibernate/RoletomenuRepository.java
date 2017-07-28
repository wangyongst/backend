package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Laoren;
import com.myweb.pojo.Roletomenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RepositoryDefinition(domainClass = Roletomenu.class, idClass = Integer.class)
public interface RoletomenuRepository extends JpaRepository <Roletomenu,Integer>{

    public List<Roletomenu>  findByRole(String role);
}