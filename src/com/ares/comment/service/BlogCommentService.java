package com.ares.comment.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.comment.dao.BlogCommentMapper;
import com.ares.comment.po.BlogComment;
import com.ares.common.authorization.AuthorityDisposer;
import com.ares.common.exception.InvalidTokenException;
import com.ares.common.exception.ParamErrorException;

public class BlogCommentService {
	@Autowired
	BlogCommentMapper blogCommentMapper;
	@Autowired
	AuthorityDisposer authorityDisposer;
	/**
	 * 发表留言
	 * @param articleComment
	 * @throws Exception
	 */
	public void addComment(BlogComment blogComment) throws Exception{
		if (StringUtils.isEmpty(blogComment.getCommContent())) {
			throw new ParamErrorException("评论内容为空");
		}
		if (StringUtils.isEmpty(blogComment.getPersonEmail())) {
			throw new ParamErrorException("邮箱为空");
		}
		if (StringUtils.isEmpty(blogComment.getPersonName())) {
			throw new ParamErrorException("昵称为空");
		}
		//初始数据
		blogComment.setCreateTime(new Date());
		blogComment.setCommSort(0);
	}
	/**
	 * 获得留言列表
	 * @return
	 * @throws Exception
	 */
	public List<BlogComment> getBlogComments() throws Exception{
		List<BlogComment> topComms = blogCommentMapper.getBlogComment();
		//遍历获得二级回复
		for (BlogComment topComm : topComms) {
			topComm.setChildComms(blogCommentMapper.getSecondComm(topComm.getCommId()));
		}
		return topComms;
	}
	/**
	 * 删除留言
	 * @param commId
	 * @param token
	 * @throws Exception
	 */
	public void deleteArticle(Integer commId, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		blogCommentMapper.deleteBlogComment(commId);
	}
}
