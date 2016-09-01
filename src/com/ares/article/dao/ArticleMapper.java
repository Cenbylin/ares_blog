package com.ares.article.dao;

import com.ares.article.po.ArticleBase;

public interface ArticleMapper {
	/**
	 * 根据博文Id获得博文对象
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public ArticleBase getArticleById(Integer articleId) throws Exception;
}
