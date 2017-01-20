package com.test.springBoot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import com.test.springBoot.entity.Phone;

@Controller
//設定 property file 設定檔的來源位置
@PropertySource("classpath:phone.properties")
public class Home {
	// phone.properties 裡的設定會自動綁定到變數
	@Value("${apple.id}") private String appleId;
    @Value("${apple.name}") private String appleName;
    @Value("${apple.price}") private int applePrice;
	
	@RequestMapping("/")
	public String index() {
		System.out.println(appleId);
		System.out.println(appleName);
		System.out.println(applePrice);
		System.out.println("index come in");
		return "index";
	}
	
	@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
		System.out.println("hello come in in ");
		System.out.println(appleId);
		System.out.println(appleName);
		System.out.println("applePrice : "+applePrice);
		model.addAttribute("name", name);
        
        List<Phone> list = new ArrayList<Phone>();
        Phone phone = null;
        phone = new Phone();
        phone.setName("Note-7爆炸");
        phone.setPrice(24999);
        list.add(phone);
        phone = new Phone();
        phone.setName("iphone-7");
        phone.setPrice(29999);
        list.add(phone);
        phone = new Phone();
        phone.setName("zenPhone-3");
        phone.setPrice(19999);
        list.add(phone);
        phone = new Phone();
        phone.setName("panda-1");
        phone.setPrice(7777);
        list.add(phone);
        phone = new Phone();
        phone.setName("tiger-1");
        phone.setPrice(5555);
        list.add(phone);
        model.addAttribute("phones", list);
        
        model.addAttribute("testStr", "iphoneIamPhone");
        
        model.addAttribute("currentDate", new Date());
        return "hello/hello";
    }
}
