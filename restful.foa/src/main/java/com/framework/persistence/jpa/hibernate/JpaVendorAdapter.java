package com.framework.persistence.jpa.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource({"classpath:/application.properties"})
@Order(3)
public class JpaVendorAdapter {

    private static final Logger logger = LogManager.getLogger(JpaVendorAdapter.class);

    @Value("${spring.jpa.generate-ddl}")
    private boolean generateDdl;
    @Value("${spring.jpa.database-platform}")
    private String databasePlatform;
    @Value("${spring.jpa.show-sql}")
    private boolean showSql;


    @Bean(name = "myJVA")
    public HibernateJpaVendorAdapter jpaVendorAdapter() throws Exception {
        logger.info("HibernateJpaVendorAdapter create!");
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setGenerateDdl(generateDdl);
        jpaVendorAdapter.setDatabasePlatform(databasePlatform);
        jpaVendorAdapter.setShowSql(showSql);
        return jpaVendorAdapter;

    }
}
