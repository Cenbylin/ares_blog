package com.ares.article.dao;

import java.util.List;

import com.ares.article.po.ArticleComment;

public interface ArticleCommentMapper {
	/**
	 * 新增一条评论
	 * @param articleComment
	 * @throws Exception
	 */
	public void addComment(ArticleComment articleComment) throws Exception;
	/**
	 * 删除一条评论
	 * @param commId
	 * @throws Exception
	 */
	public void deleteComment(Integer commId) throws Exception;
	/**
	 * 删除多条评论
	 * @param commIds
	 * @throws Exception
	 */
	public void deleteComments(List<Integer> commIds) throws Exception;
	/**
	 * 获得所有回复
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public List<Integer> getAllByArticle(Integer articleId) throws Exception;
	/**
	 * 获得顶层回复
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public List<ArticleComment> getTopCommByArticle(Integer articleId) throws Exception;
	/**
	 * 获得二级回复
	 * @param topCommId
	 * @return
	 * @throws Exception
	 */
	public List<ArticleComment> getSecondComm(Integer topCommId) throws Exception;
}