package com.ares.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ares.article.po.ArticleBase;

public interface ArticleMapper {
	/**
	 * 根据博文Id获得博文对象
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public ArticleBase getArticleById(Integer articleId) throws Exception;
	/**
	 * 根据博文Id删除博文记录
	 * @param articleId
	 * @throws Exception
	 */
	public void deleteArticleById(Integer articleId) throws Exception;
	/**
	 * 更新博文记录
	 * @param articleBase
	 * @throws Exception
	 */
	public void updateArticle(ArticleBase articleBase) throws Exception;
	/**
	 * 增加博文记录
	 * @param articleBase
	 * @throws Exception
	 */
	public void addArticle(ArticleBase articleBase) throws Exception;
	/**
	 * 获得博文列表（分页）
	 * @param pageNum 当前页数
	 * @param pageSize 分页大小
	 * @return
	 * @throws Exception
	 */
	public List<ArticleBase> getArticles(@Param("pageNum") Integer pageNum,
			@Param("pageSize") Integer pageSize) throws Exception;
	/**
	 * 根据标签id获得博文列表（分页）
	 * @param tagId 标签id
	 * @param pageNum 当前页数
	 * @param pageSize 分页大小
	 * @return
	 * @throws Exception
	 */
	public List<ArticleBase> getArticleByTag(@Param("tagId") Integer tagId,
			@Param("pageNum") Integer pageNum,
			@Param("pageSize") Integer pageSize) throws Exception;
}
