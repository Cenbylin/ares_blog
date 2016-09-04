package com.ares.blogbase.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.blogbase.dao.BlogBaseMapper;
import com.ares.blogbase.po.BlogBase;
import com.ares.common.exception.RepeatCreatingException;

public class BlogBaseService {
	@Autowired
	BlogBaseMapper baseMapper;
	
	/**
	 * 博客创建
	 * @param blogBase
	 * @throws Exception
	 */
	public void createBlog(BlogBase blogBase) throws Exception{
		//判断博客配置是否已经存在
		if(baseMapper.getBlogBase()==null){
			throw new RepeatCreatingException("博客已经创建过。");
		}
		//创建配置
		baseMapper.addBlogBase(blogBase);
	}
	/**
	 * 更新博客配置
	 * @throws Exception
	 */
	public void updateConfig(BlogBase blogBase) throws Exception{
		baseMapper.updateBlogBase(blogBase);
	}
	
}
