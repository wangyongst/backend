package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Password;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Password.class, idClass = Integer.class)
public interface PasswordRepository extends JpaRepository<Password,Integer> {

    public List<Password> findByPassword(String password);
}