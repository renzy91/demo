package com.channelsoft.demo.controller;

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

}
