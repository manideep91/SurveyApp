package com.mmdworks.surveyapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SuppressWarnings("deprecation")
public class SurveyAppInitialiser extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SurveyApplication.class); 
	}

}
