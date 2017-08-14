package com.boot.spring.boot;

import com.framework.boot.login.authimg.AuthImageServlet;
import com.framework.boot.login.filter.LoginFilter;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.util.Log4jConfigListener;

import java.util.*;

/**
 * Created by BHWL on 2017-08-09.
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@EnableJpaRepositories(basePackages = {"com.myweb.dao.jpa"})
@ComponentScan(basePackages = {"com.myweb"})
@EntityScan(basePackages = {"com.myweb.pojo"})
public class MainApplication extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class,args);
    }

    @Bean
    public FilterRegistrationBean loginFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //LoginFilter
        LoginFilter loginFilter = new LoginFilter();
        registrationBean.setFilter(loginFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("*.do");
        urlPatterns.add("*.jsp");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

   // @Bean
    public FilterRegistrationBean hiddenHttpMethodFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//
//        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
//        registrationBean.setFilter(hiddenHttpMethodFilter);
//        List<String> urlPatterns = new ArrayList<String>();
//        urlPatterns.add("*.do");
//        urlPatterns.add("*.jsp");
//        registrationBean.set
        return registrationBean;
    }

    @Bean
    public ServletRegistrationBean authImageServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean();

        AuthImageServlet authImageServlet = new AuthImageServlet();
        registrationBean.setServlet(authImageServlet);
        List<String> urlMappings = new ArrayList<String>();
        urlMappings.add("/authImage.do");////访问，可以添加多个
        registrationBean.setUrlMappings(urlMappings);
        return registrationBean;
    }


    //@Bean
    public ServletListenerRegistrationBean<EventListener> getDemoListener() {
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>();
//        registrationBean.setListener(new Log4jConfigListener());
//        Map parameters = new HashMap<String, String>();
//        parameters.put("log4jConfigLocation", "classpath:properties/log4j.properties");
//        registrationBean.setInitParameters(parameters);
        return registrationBean;
    }
}
