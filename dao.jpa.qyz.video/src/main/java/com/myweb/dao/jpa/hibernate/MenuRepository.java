package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Menu;
import com.myweb.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Menu.class, idClass = Integer.class)
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    @Query("select a from Menu a,Roletomenu b where a.parent = ?1 and a.id = b.menuid and b.role = ?2 order by shunxu")
    public List<Menu> queryByParentAndRole(int parent, String role);

}