package com.channelsoft.demo.controller;

import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
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

}
