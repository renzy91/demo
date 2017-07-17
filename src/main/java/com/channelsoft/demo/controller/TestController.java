package com.channelsoft.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/testgo")
	@ResponseBody
	public String testGo(){
		System.out.println("123");
		return "12345";
	}
	
	/**
	 * jsonp接口
	 * @Title: testJsonp
	 * @param callback
	 * @return
	 * @throws
	 */
	@RequestMapping("/testJsonp")
	@ResponseBody
	public JSONPObject testJsonp(String callback){
		System.out.println("testJsonp");
		String value = "testJsonp";
		return new JSONPObject(callback, value);
	}
	
	@RequestMapping("/gotoIndex")
	public String gotoIndex(HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		
		session.setAttribute("123", 123);
		
		return "index";
	}

}
