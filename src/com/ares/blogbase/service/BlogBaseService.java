package com.ares.blogbase.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.blogbase.dao.BlogBaseMapper;
import com.ares.blogbase.po.BlogBase;
import com.ares.common.authorization.AuthorityDisposer;
import com.ares.common.exception.RepeatCreatingException;

public class BlogBaseService {
	@Autowired
	BlogBaseMapper blogBaseMapper;
	@Autowired
	AuthorityDisposer authorityDisposer;
	
	/**
	 * 博客创建
	 * @param blogBase
	 * @throws Exception
	 */
	public void createBlog(BlogBase blogBase) throws Exception{
		//判断博客配置是否已经存在
		if(blogBaseMapper.getBlogBase()==null){
			throw new RepeatCreatingException("博客已经创建过。");
		}
		//创建配置
		blogBaseMapper.addBlogBase(blogBase);
	}
	/**
	 * 更新博客配置
	 * @throws Exception
	 */
	public void updateConfig(BlogBase blogBase) throws Exception{
		blogBaseMapper.updateBlogBase(blogBase);
	}

	/**
	 * 登陆，返回token
	 * @param adminNickname
	 * @param adminPassword
	 * @return token
	 * @throws Exception 
	 */
	public String login(String adminNickname, String adminPassword) throws Exception {
		BlogBase blogBase = blogBaseMapper.getBlogBaseByNicknameAndPassword(adminNickname, adminPassword);
		if (blogBase==null) {
			throw new LoginException("账号或者密码错误！");
		}
		return authorityDisposer.getCurrentToken();
	}
}
