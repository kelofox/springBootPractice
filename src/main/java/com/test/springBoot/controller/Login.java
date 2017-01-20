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
 * google recaptcha 範例
 *
 */

@Controller
public class Login {
	
	public static final String url = "https://www.google.com/recaptcha/api/siteverify";
	public static final String secret = "6LeAQBIUAAAAAF-TacnezU6IGJMGvymbhJ8PpYJ_";
	private final static String USER_AGENT = "Mozilla/5.0";
	
	
	@RequestMapping("/login")
    public String login(Model model, LoginForm loginForm) {
		model.addAttribute("loginForm",loginForm);
        return "login/login";
    }
	
	@RequestMapping("/goLogin")
    public String goLogin(Model model, LoginForm loginForm, HttpServletRequest request) {
		System.out.println(loginForm.getUid());
		System.out.println(loginForm.getPwd());
		// get reCAPTCHA request param
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		System.out.println(gRecaptchaResponse);
		try {
			boolean verifyResult = verify(gRecaptchaResponse);
			System.out.println("verifyResult : " + verifyResult);
			if(!verifyResult){
				model.addAttribute("errMsg", "Recaptcha verify fail!");
				return "login/login";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("errMsg", e.toString());
			return "login/login";
		}
		model.addAttribute("loginForm",loginForm);
        return "login/loginSuccess";
    }
	
	//驗證reCAPTCHA
	public static boolean verify(String gRecaptchaResponse) throws IOException {
		if (gRecaptchaResponse == null || "".equals(gRecaptchaResponse)) {
			return false;
		}
		
		try{
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

		String postParams = "secret=" + secret + "&response="
				+ gRecaptchaResponse;

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + postParams);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		
		//parse JSON response and return 'success' value
		JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		return jsonObject.getBoolean("success");
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
	
