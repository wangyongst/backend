package com.framework.datasource.tomcatjdbc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.annotation.Order;

import java.beans.PropertyVetoException;

@Configuration
@PropertySource({"classpath:/properties/application.properties"})
@Order(2)
public class TomcatJdbcDataSource {
    private static final Logger logger = LogManager.getLogger(TomcatJdbcDataSource.class);

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.tomcat.jmx-enabled}")
    private boolean jmxEnabled;
    @Value("${spring.datasource.tomcat.test-while-idle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.tomcat.test-on-borrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.tomcat.validation-interval}")
    private long validationInterval;
    @Value("${spring.datasource.tomcat.test-on-return}")
    private boolean testOnReturn;
    @Value("${spring.datasource.tomcat.validation-query}")
    private String validationQuery;
    @Value("${spring.datasource.tomcat.time-between-eviction-runs-millis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.tomcat.max-active}")
    private int maxActive;
    @Value("${spring.datasource.tomcat.initial-size}")
    private int initialSize;
    @Value("${spring.datasource.tomcat.max-wait}")
    private int maxWait;
    @Value("${spring.datasource.tomcat.remove-abandoned-timeout}")
    private int removeAbandonedTimeout;
    @Value("${spring.datasource.tomcat.min-evictable-idle-time-millis}")
    private int minEvictableIdleTimeMillis;
    @Value("${spring.datasource.tomcat.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.tomcat.log-abandoned}")
    private boolean logAbandoned;
    @Value("${spring.datasource.tomcat.remove-abandoned}")
    private boolean removeAbandoned;

    /**
     * 描述 : <负责解析资源文件>. <br>
     * <p>
     * <这个类必须有，而且必须声明为static，否则不能正常解析>
     * </p>
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer placehodlerConfigurer() {
        logger.info("PropertySourcesPlaceholderConfigurer create!");
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(name = "myDS")
    public DataSource dataSource() throws PropertyVetoException {
        logger.info("TomcatJdbcDataSource create!");
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJmxEnabled(jmxEnabled);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setValidationInterval(validationInterval);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setRemoveAbandoned(removeAbandoned);
        return dataSource;
    }
}
