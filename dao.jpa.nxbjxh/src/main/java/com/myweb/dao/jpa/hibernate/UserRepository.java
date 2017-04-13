package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = User.class, idClass = Integer.class)
public interface UserRepository extends JpaRepository<User,Integer> {

    public List<User> findByUsernameAndPassword(String username, String password);

    public List<User> findByUsername(String username);

    public List<User> findByNumber(String number);

    public List<User> findByIdentity(String identity);

    public List<User> findByUsernameAndIdNot(String username,int id);

    public List<User> findByIdentityAndIdNot(String identity,int id);

    public List<User> findByNameAndIdentityAndUsername(String name,String identity,String username);
}