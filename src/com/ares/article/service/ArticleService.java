package com.ares.article.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.article.dao.ArticleMapper;
import com.ares.article.po.ArticleBase;

public class ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	
	public ArticleBase getArticleById(Integer articleId) throws Exception{
		return articleMapper.getArticleById(articleId);
	}
}
