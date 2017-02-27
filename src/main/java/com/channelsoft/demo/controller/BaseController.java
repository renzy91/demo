package com.channelsoft.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void writeJson(HttpServletResponse response, Object object, String callback) {
		String i = JSON.toJSONString(object);
		logger.info("writeJson()...传递消息为[" + i + "]");
		response.setContentType("text/plain;charset=utf-8");
		response.setHeader("Access-Control-Allow-Origin", "*");//允许跨域
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
		try {
			response.getWriter().print(callback + "(" + i +")");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
