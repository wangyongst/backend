package com.myweb.dao.jpa;

import com.myweb.pojo.Haochi;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by BHWL on 2017-04-18.
 */
@Repository
@RepositoryDefinition(domainClass = Haochi.class, idClass = Integer.class)
public interface MyRepository{

}
