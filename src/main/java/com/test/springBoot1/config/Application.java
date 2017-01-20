package com.test.springBoot1.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = { 
		"com.test.springBoot.config", 
		"com.test.springBoot.controller" })
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/**
 * 
 *  �����G
 *  @SpringBootApplication ��annotation ����ϥ�@Configuration, @EnableAutoConfiguration and @ComponentScan �C
 *  
 *  
 *  ����G
 *  �I��Application.java > Run as > Java Application
 *  �Ұʫ�A�}���s������J http://localhost:8080/ or ��J http://localhost:8080/hello/xxxx
 *  
 */
