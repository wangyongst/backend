package com.framework.persistence.jpa.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@PropertySource({"classpath:/application.properties"})
@Order(3)
public class TransactionManager {

    private static final Logger logger = LogManager.getLogger(TransactionManager.class);

    @Autowired
    @Qualifier("myEMF")
    private EntityManagerFactory entityManagerFactory;

    @Bean(name = "myTM")
    public JpaTransactionManager transactionManager() {
        logger.info("JpaTransactionManager create!");
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
