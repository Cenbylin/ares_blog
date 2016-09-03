package com.ares.article.dao;

import java.util.List;

import com.ares.article.po.ArticleTag;

public interface ArticleTagMapper {
	/**
	 * 获得所有标签
	 * @return
	 * @throws Exception
	 */
	public List<ArticleTag> getTags() throws Exception;
	/**
	 * 查询article的关联tag
	 * @return
	 * @throws Exception
	 */
	public List<ArticleTag> getTagByArticleId(Integer articleId) throws Exception;
}
