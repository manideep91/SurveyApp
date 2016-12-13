package com.mmdworks.surveyapp;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

@Configuration
@PropertySources({ @PropertySource("classpath:db.properties"),
@PropertySource("classpath:hibernate.properties")})
public class SurveyAppConfig {
   
		// DB properties const.properties
		@Value("${db.driver}")
		private String DATABASE_DRIVER;
		@Value("${db.password}")
		private String DATABASE_PASSWORD;
		@Value("${db.url}")
		private String DATABASE_URL;
		@Value("${db.username}")
		private String DATABASE_USERNAME;
		@Value("${hibernate.dialect}")
		private String HIBERNATE_DIALECT;
		@Value("${hibernate.show_sql}")
		private String HIBERNATE_SHOW_SQL;
		@Value("${hibernate.hbm2ddl.auto}")
		private String HIBERNATE_HBM2DDL_AUTO;
	 	
		@Bean(name = "dataSource")
	 	public DataSource getDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
	    basicDataSource.setUrl(DATABASE_URL);
		basicDataSource.setUsername(DATABASE_USERNAME);
		basicDataSource.setPassword(DATABASE_PASSWORD);
		return basicDataSource;
		}
		
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
			sessionFactory.setDataSource(getDataSource());
			Properties hibernateProperties = new Properties();
			hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
			hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
			hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
			sessionFactory.setHibernateProperties(hibernateProperties);
			sessionFactory.setPackagesToScan("com.tf.usermanagement");
			return sessionFactory;
		}

		
		
}  
   
   
   
   
   
   
   