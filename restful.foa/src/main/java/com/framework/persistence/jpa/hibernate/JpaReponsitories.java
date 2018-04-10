package com.framework.persistence.jpa.hibernate;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by BHWL on 2016-12-19.
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.myweb.dao.jpa", repositoryImplementationPostfix = "Impl", entityManagerFactoryRef = "myEMF", transactionManagerRef = "myTM")
@Order(3)
public class JpaReponsitories {
}
