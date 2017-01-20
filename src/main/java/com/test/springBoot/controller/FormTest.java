package com.test.springBoot.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springBoot.entity.Phone;
import com.test.springBoot.form.PhoneForm;

@Controller
public class FormTest {
	
	@RequestMapping("/goInput")
	public String goInput(Model model,PhoneForm form) {
		
		List<Phone> list = new ArrayList<Phone>();
        Phone phone = null;
        phone = new Phone();
        phone.setName("Note-7");
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
		
		model.addAttribute("phoneForm", form);
		model.addAttribute("errorMessage", "errorMessage test");
		model.addAttribute("testStr", "I am test str");
		return "form/input";
	}
	
	@RequestMapping("/goSubmit")
	public String goResult(Model model,@Valid PhoneForm form,BindingResult result) {
		model.addAttribute("phoneForm", form);
		if(result.hasErrors()){
			List<ObjectError>  errList = result.getAllErrors();
			for(ObjectError error:errList){
				System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
			}
			//return "redirect:/goInput";
			return "form/input :: ajaxtest";
		}
		
		return "form/result";
	}
	
	@RequestMapping("/goAjax")
	public String goAjax(Model model, HttpServletRequest request){
		String str = request.getParameter("str");
		String str2 = request.getParameter("str2");
		String checkCode = (String)request.getSession().getAttribute("checkCode");
		System.out.println(str);
		System.out.println(checkCode);
		return "layout/footer :: goldfooter";
	}
	
	//生成隨機驗證碼圖片
	@RequestMapping("/goGraphic")
	public void goGraphic(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("image/jpeg");
		HttpSession session = request.getSession();
		int width =100;
		int height=40;
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		//创建内存图像并获得其图形上下文
		BufferedImage image =new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		//产生随机码
		//定义随机码的字符表
		String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands = new char[4];
		for(int i=0;i<4;i++){
			int rand =(int)(Math.random()*36);
			rands[i] =chars.charAt(rand);
		}
		g.setColor(new Color(0xDCDCDC));
		g.fillRect(0, 0, width, height);
		for(int i=0;i<500;i++){
			int x=(int)(Math.random()*width);
			int y=(int)(Math.random()*height);
			int red=(int)(Math.random()*255);
			int green=(int)(Math.random()*255);
			int blue=(int)(Math.random()*255);
			g.setColor(new Color(red,green,blue));
			g.drawOval(x, y, 1, 0);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font(null,Font.ITALIC,30));
		//在不同高度上输出验证码的不同字符
		g.drawChars(rands, 0, 1, 1, 35);
		g.drawChars(rands,1,1, 24, 30);
		g.drawChars(rands,2,1, 42, 25);
		g.drawChars(rands,3,1, 57, 32);
		//g.drawChars(rands,4,1, 61, 19);
		//g.drawChars(rands,5,1, 76, 22);
		g.dispose();
		//将图像输出到客户端
		ServletOutputStream sos = response.getOutputStream();
		ByteArrayOutputStream baos =new ByteArrayOutputStream();
		ImageIO.write(image,"JPEG",baos);
		byte[] buffer = baos.toByteArray();
		response.setContentLength(buffer.length);
		sos.write(buffer);
		baos.flush();
		baos.close();
		sos.flush();
		sos.close();
		//将验证码放到 session 中
		session.setAttribute("checkCode", new String(rands));
		//model.addAttribute("checkCode", new String(rands));
		model.addAttribute("testStr", "I am test str");
		System.out.println(rands);
		//return "form/input";
	}
}
