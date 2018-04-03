package com.framework.boot.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import java.util.EnumSet;

@Configuration
@Order(4)
public class WebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext)
            throws ServletException {

        //加载Spring配置
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(SpringConfig.class);
        Dynamic dispatcherDynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
        dispatcherDynamic.addMapping("*.do");
        dispatcherDynamic.setLoadOnStartup(1);

        //HiddenHttpMethodFilter
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        FilterRegistration.Dynamic hiddenHttpMethodFilterRegistration = servletContext.addFilter("hiddenHttpMethodFilter", hiddenHttpMethodFilter);
        hiddenHttpMethodFilterRegistration.addMappingForServletNames(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "dispatcher");

        //CharacterEncodingFilter
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("utf-8");
        encodingFilter.setForceEncoding(true);
        FilterRegistration.Dynamic encodingFilterRegistration = servletContext.addFilter("encodingFilter", encodingFilter);
        encodingFilterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE), false, "/*");

    }
}