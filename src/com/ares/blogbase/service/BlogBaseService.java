package com.ares.blogbase.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.blogbase.dao.BlogBaseMapper;
import com.ares.blogbase.po.BlogBase;
import com.ares.common.authorization.AuthorityDisposer;
import com.ares.common.exception.InvalidTokenException;
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
	public void updateConfig(BlogBase blogBase, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		blogBaseMapper.updateBlogBase(blogBase);
	}

	/**
	 * 获得博客配置
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public BlogBase getBlogBase() throws Exception{
		
		return blogBaseMapper.getBlogBase();
	}
	/**
	 * 修改密码
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public void updatePassword(String token, String adminPassword) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		blogBaseMapper.updatePassword(adminPassword);
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
