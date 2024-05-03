package com.telusko.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan({"com.telusko"})
public class TeluskoConfig {
	
     @Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr=new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/view/");//To set path of the file
		vr.setSuffix(".jsp");//To give the extension of the file
		
		
		return vr;
	}
}
