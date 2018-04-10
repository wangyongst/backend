package com.framework.boot.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@ComponentScan(basePackages = { "com.framework", "com.myweb" })
@EnableWebMvc
@Order(4)
public class SpringConfig extends WebMvcConfigurerAdapter {

	private static final Logger logger = LogManager.getLogger(SpringConfig.class);

	@Bean
	public ViewResolver viewResolver() {
		logger.info("ViewResolver create!");
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		logger.info("ConfigureMessageConverters create!");
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()	.indentOutput(true);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}

}
