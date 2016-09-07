package com.ares.blogbase.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.blogbase.service.BlogBaseService;

/**
 * 博客配置控制器（RESTful）
 * @author Cenby7
 *
 */
@Controller
@RequestMapping("blogBase")
public class BlogBaseController {
	@Autowired
	BlogBaseService blogBaseService;
	
	@RequestMapping(value="token/{adminNickname}/{adminPassword}", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> login(@PathVariable("adminNickname") String adminNickname,
			@PathVariable("adminPassword") String adminPassword) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("token", blogBaseService.login(adminNickname, adminPassword));
		//异常交由统一异常处理
		return res;
	}
}
