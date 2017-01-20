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
 *  弧
 *  Spring 4.0 穝糤@RestController 狦璶ㄏノRESTful Web Services ㄏノ硂Annotation
 *  hello よ猭硂ㄏノRESTful{}癸URL秈︽把计て
 *   @PathVariable 琵Spring笆盢癸莱URL把计锣传よ猭把计
 *  
 */




