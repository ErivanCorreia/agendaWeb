package com.agenda.webapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.agenda.webapp.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	public DBService dbService;
	
	@Bean
	public boolean instanciaDB() throws Exception{
		dbService.instanciaDB();
		return true;
	}
	
}
