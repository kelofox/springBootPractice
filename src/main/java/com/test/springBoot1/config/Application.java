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
 *  說明：
 *  @SpringBootApplication 此annotation 等於使用@Configuration, @EnableAutoConfiguration and @ComponentScan 。
 *  
 *  
 *  執行：
 *  點選Application.java > Run as > Java Application
 *  啟動後，開啟瀏灠器輸入 http://localhost:8080/ or 輸入 http://localhost:8080/hello/xxxx
 *  
 */
