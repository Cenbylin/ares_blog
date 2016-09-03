package com.ares.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ares.article.dao.ArticleTagMapper;
import com.ares.article.po.ArticleTag;

public class ArticleTagService {
	@Autowired
	ArticleTagMapper articleTagMapper;
	
	/**
	 * 根据文章查询标签
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public List<ArticleTag> getArticleTagByArticle(Integer articleId) throws Exception{
		return articleTagMapper.getTagByArticleId(articleId);
	}
	/**
	 * 获得所有标签
	 * @return
	 * @throws Exception
	 */
	public List<ArticleTag> getArticleTags() throws Exception{
		return articleTagMapper.getTags();
	}
}
