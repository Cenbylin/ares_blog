package com.ares.article.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.article.dao.ArticleCommentMapper;
import com.ares.article.po.ArticleComment;
import com.ares.common.authorization.AuthorityDisposer;
import com.ares.common.exception.InvalidTokenException;
import com.ares.common.exception.ParamErrorException;

public class ArticleCommentService {
	@Autowired
	ArticleCommentMapper articleCommentMapper;
	@Autowired
	AuthorityDisposer authorityDisposer;
	
	/**
	 * 发表博文评论
	 * @param articleComment
	 * @throws Exception
	 */
	public void addArticleComment(ArticleComment articleComment) throws Exception{
		if (StringUtils.isEmpty(articleComment.getCommContent())) {
			throw new ParamErrorException("评论内容为空");
		}
		if (StringUtils.isEmpty(articleComment.getPersonEmail())) {
			throw new ParamErrorException("邮箱为空");
		}
		if (StringUtils.isEmpty(articleComment.getPersonName())) {
			throw new ParamErrorException("昵称为空");
		}
		//初始数据
		articleComment.setCreateTime(new Date());
		articleComment.setCommSort(0);
		articleCommentMapper.addComment(articleComment);
	}
	/**
	 * 删除评论
	 * @param commId
	 * @param token
	 * @throws Exception
	 */
	public void deleteArticleComment(Integer commId, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		articleCommentMapper.deleteComment(commId);
	}
	
}
