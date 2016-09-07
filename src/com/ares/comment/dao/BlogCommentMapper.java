package com.ares.comment.dao;

import java.util.List;

import com.ares.article.po.ArticleComment;
import com.ares.comment.po.BlogComment;


public interface BlogCommentMapper {
	/**
	 * 新增留言
	 * @param blogComment
	 * @throws Exception
	 */
	public void addBlogComment(BlogComment blogComment) throws Exception;
	/**
	 * 删除留言
	 * @param commId
	 * @throws Exception
	 */
	public void deleteBlogComment(Integer commId) throws Exception;
	/**
	 * 获得留言
	 * @throws Exception
	 */
	public List<BlogComment> getBlogComment() throws Exception;
	/**
	 * 获得二级留言
	 * @param topCommId
	 * @return
	 * @throws Exception
	 */
	public List<ArticleComment> getSecondComm(Integer topCommId) throws Exception;
}