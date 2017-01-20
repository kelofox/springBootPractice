package com.test.springBoot1.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloBootController {
	@RequestMapping("/")
	public String helloPage() {
		return "index";
	}

	@RequestMapping("/hello/{name}")
	public @ResponseBody
	String hello(@PathVariable("name") String name) {
		return "Hello " + name;
	}
}

/**
 * 
 *  �����G
 *  Spring 4.0 �s�W��@RestController �A�p�G�n�ϥ�RESTful Web Services �i�H�ϥγoAnnotation
 *  �bhello ��k�o�ϥ�RESTful�A�[�J{}��URL�i��ѼƤơC
 *  �[�J @PathVariable ��Spring�۰ʱN������URL�Ѽ��ഫ������k���Ѽ�
 *  
 */




