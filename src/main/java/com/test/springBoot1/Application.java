package com.test.springBoot1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/**
 * 
 *  �����G
 *  @Configuration �ϥ� Java Class �@���]�w�A(�DXML)
 *  @ComponentScan�۰ʱ��y Spring Bean ����
 *  @EnableAutoConfiguration �ҥ� Spring Boot �۰ʰt�m�A�N�۰ʧP�_�M�רϥΨ쪺�M��A�إ߬������]�w�C
 *  
 *  
 *  ����G
 *  �I��Application.java > Run as > Java Application
 *  �Ұʫ�A�}���s������J http://localhost:8080/ or ��J http://localhost:8080/hello/xxxx
 *  
 */
