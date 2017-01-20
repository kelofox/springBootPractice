package com.test.springBoot.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.springBoot.form.LoginForm;

/**
 * @author 
 * 
 * Qrcode ＆ Barcode
 *
 */

@Controller
public class Code {
	
	@RequestMapping("/qrcode")
    public String qrcode(Model model) {

        return "code/qrcode";
    }
	
	@RequestMapping("/makeQrcode")
    public String makeQrcode(Model model, HttpServletRequest request) {
		String content = request.getParameter("content");
		System.out.println(content);
		model.addAttribute("content",content);
        return "code/makeQrcode";
    }
	
	@RequestMapping("/barcode")
    public String barcode(Model model) {

        return "code/barcode";
    }
	
	@RequestMapping("/makeBarcode")
    public String makeBarcode(Model model, HttpServletRequest request) {
		String content = request.getParameter("content");
		System.out.println(content);
		model.addAttribute("content",content);
        return "code/makeBarcode";
    }
	
}
	
