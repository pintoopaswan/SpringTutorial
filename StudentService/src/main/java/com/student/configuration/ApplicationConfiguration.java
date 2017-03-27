package com.student.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author PPaswan
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.student")


public class ApplicationConfiguration extends WebMvcConfigurerAdapter {
	
	/**
	 * addResourceHandlers : Method to handle the static and AngularJS resources
	 */
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/**").addResourceLocations("/");
	}

	/*
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) { 
	        configurer.enable();
	}*/
	
	/**
	 * propertySourcesPlaceholderConfigurer : Method to return a bean for reading .proerties file
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}
	
}
