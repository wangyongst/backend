package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Laoren;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RepositoryDefinition(domainClass = Laoren.class, idClass = Integer.class)
public interface LaorenRepository extends JpaRepository<Laoren, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Laoren l set l.type =?1 where l.id = ?2")
    public int updateTypeById(int type, int id);
}