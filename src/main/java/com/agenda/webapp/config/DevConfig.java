package com.agenda.webapp.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agenda.webapp.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	public DBService dbService; 
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	public String strategy;
	
	@Bean
	public boolean instanciaDB() throws ParseException{
		
		if(!"create".equals(strategy)) {
			return false;
		}
		
		dbService.instanciaDB();
		return true;
		
	}

}
