package com.ares.blogbase.dao;

import org.apache.ibatis.annotations.Param;

import com.ares.blogbase.po.BlogBase;

public interface BlogBaseMapper {
	/**
	 * 获得博客配置
	 * @return
	 * @throws Exception
	 */
	public BlogBase getBlogBase() throws Exception;
	/**
	 * 根据用户账号密码获得记录
	 */
	public BlogBase getBlogBaseByNicknameAndPassword(@Param("nickname") String nickname,@Param("password") String password) throws Exception;
	/**
	 * 增加博客配置（用于博客安装）
	 * @param blogBase
	 * @throws Exception
	 */
	public void addBlogBase(BlogBase blogBase) throws Exception;
	/**
	 * 更新博客配置
	 * @param blogBase
	 * @throws Exception
	 */
	public void updateBlogBase(BlogBase blogBase) throws Exception;
	/**
	 * 修改密码
	 * @param adminPassword
	 * @throws Exception
	 */
	public void updatePassword(String adminPassword) throws Exception;
}