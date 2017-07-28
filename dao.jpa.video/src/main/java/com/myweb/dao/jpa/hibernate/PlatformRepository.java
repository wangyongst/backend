package com.myweb.dao.jpa.hibernate;

import com.myweb.pojo.Platform;
import com.myweb.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryDefinition(domainClass = Platform.class, idClass = Integer.class)
public interface PlatformRepository extends JpaRepository<Platform, Integer> {

    public List<Platform> findByUse(Integer use);

    public List<Platform> findByUseNot(Integer use);
}