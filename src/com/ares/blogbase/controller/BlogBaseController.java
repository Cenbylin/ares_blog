package com.ares.blogbase.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.blogbase.po.BlogBase;
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
	
	/**
	 * 登陆，获得token
	 * @param adminNickname
	 * @param adminPassword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/token/{adminNickname}/{adminPassword}", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> login(@PathVariable("adminNickname") String adminNickname,
			@PathVariable("adminPassword") String adminPassword) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("token", blogBaseService.login(adminNickname, adminPassword));
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 获得博客配置
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getBlogBase() throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("token", blogBaseService.getBlogBase());
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 创建博客
	 * @param blogBase
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> createBlogBase(BlogBase blogBase) throws Exception{
		HashMap<String, Object > res = new HashMap<String, Object>();
		res.put("state", true);
		blogBaseService.createBlog(blogBase);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 修改配置
	 * @param blogBase
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.PUT)
	public @ResponseBody HashMap<String, Object> updateBlogBase(BlogBase blogBase, String token) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		blogBaseService.updateConfig(blogBase, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 修改密码
	 * @param blogBase
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/password", method=RequestMethod.PUT)
	public @ResponseBody HashMap<String, Object> updatePassword(String token, String adminPassword) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		blogBaseService.updatePassword(token, adminPassword);
		//异常交由统一异常处理
		return res;
	}
	
}
