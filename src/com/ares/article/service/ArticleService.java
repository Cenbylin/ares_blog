package com.ares.article.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.article.dao.ArticleMapper;
import com.ares.article.po.ArticleBase;

public class ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	
	public ArticleBase getArticleById(Integer articleId) throws Exception{
		//以下是测试
		ArticleBase bean = new ArticleBase();
		bean.setCreateTime(new Date());
		bean.setArticleSort(0);
		bean.setArticleTitle("666");
		bean.setArticleContent("666".getBytes("UTF-8"));
		bean.setArticleState(0);
		articleMapper.deleteArticleById(2);
		
		
		
		return articleMapper.getArticleById(articleId);
	}
}
