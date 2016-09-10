package com.ares.article.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.ares.article.dao.ArticleCommentMapper;
import com.ares.article.dao.ArticleMapper;
import com.ares.article.dao.ArticleTagMapper;
import com.ares.article.po.ArticleAndTags;
import com.ares.article.po.ArticleBase;
import com.ares.article.po.ArticleComment;
import com.ares.common.authorization.AuthorityDisposer;
import com.ares.common.exception.InvalidTokenException;
import com.ares.common.exception.NoDataException;
import com.ares.common.utils.ByteBlobTool;
import com.ares.common.utils.Constants;
import com.ares.common.utils.HtmlTool;

public class ArticleService {
	@Autowired
	ArticleMapper articleMapper;
	@Autowired
	ArticleCommentMapper articleCommentMapper;
	@Autowired
	ArticleTagMapper articleTagMapper;
	@Autowired
	AuthorityDisposer authorityDisposer;
	
	/**
	 * 获得博文详情（包括回复列表）
	 * @param articleId
	 * @return
	 * @throws Exception
	 */
	public ArticleBase getArticleById(Integer articleId) throws Exception{
		ArticleBase bean = articleMapper.getArticleById(articleId);
		if (bean==null) {
			throw new NoDataException("No such article with id(" + articleId + ")");
		}
		bean.setArticleComms(getArticleComments(articleId));
		bean.setArticleContentStr(ByteBlobTool.blobToString(bean.getArticleContent()));
		return bean;
	}
	/**
	 * 发表文章
	 * @param articleBase
	 * @throws Exception
	 */
	public void addArticle(ArticleBase articleBase, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		//初始数据
		articleBase.setCreateTime(new Date());
		articleBase.setArticleContent(articleBase.getArticleContentStr().getBytes("UTF-8"));
		//截取博文摘要
		if (StringUtils.isEmpty(articleBase.getArticleIntro())) {
			String longContent = HtmlTool.stripHtml(ByteBlobTool.blobToString(articleBase.getArticleContent()));
			articleBase.setArticleIntro(longContent.length()>50 ? longContent.substring(0, 50):longContent);
		}
		articleMapper.addArticle(articleBase);
		//增加标签关联
		List<Integer> tags = new ArrayList<Integer>();
		String[] tagss = articleBase.getTags().split(",");
		for (int i = 0; i < tagss.length; i++) {
			tags.add(Integer.valueOf(tagss[i]));
		}
		ArticleAndTags articleAndTags = new ArticleAndTags(articleBase.getArticleId(), tags);
		articleTagMapper.updateTagOfArticle(articleAndTags);
	}
	/**
	 * 更新文章
	 * @param articleBase
	 * @param token
	 * @throws Exception
	 */
	public void updateArticle(ArticleBase articleBase, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		//截取博文摘要
		if (StringUtils.isEmpty(articleBase.getArticleIntro())) {
			String longContent = HtmlTool.stripHtml(ByteBlobTool.blobToString(articleBase.getArticleContent()));
			articleBase.setArticleIntro(longContent.length()>50 ? longContent.substring(0, 50):longContent);
		}
		articleMapper.updateArticle(articleBase);
		//改变标签关联
		List<Integer> tags = new ArrayList<Integer>();
		String[] tagss = articleBase.getTags().split(",");
		for (int i = 0; i < tagss.length; i++) {
			tags.add(Integer.valueOf(tagss[i]));
		}
		ArticleAndTags articleAndTags = new ArticleAndTags(articleBase.getArticleId(), tags);
		articleTagMapper.updateTagOfArticle(articleAndTags);
	}
	/**
	 * 获得文章列表
	 * @param pageNum 当前页数
	 * @return
	 * @throws Exception
	 */
	public List<ArticleBase> getArticles(Integer pageNum) throws Exception{
		
		return articleMapper.getArticles(pageNum, Constants.PAGESIZE);
	}
	/**
	 * 获得标签下文章列表
	 * @param pageNum 当前页数
	 * @return
	 * @throws Exception
	 */
	public List<ArticleBase> getArticleByTag(Integer tagId, Integer pageNum) throws Exception{
		
		return articleMapper.getArticleByTag(tagId, pageNum, Constants.PAGESIZE);
	}
	/**
	 * 删除博文
	 * @param articleId
	 * @param token
	 * @throws Exception
	 */
	public void deleteArticle(Integer articleId, String token) throws Exception{
		//校验token
		if (!authorityDisposer.validate(token)) {
			throw new InvalidTokenException("token过期");
		}
		ArticleBase bean = articleMapper.getArticleById(articleId);
		if (bean==null) {
			throw new NoDataException("No such article with id(" + articleId + ")");
		}
		articleMapper.deleteArticleById(articleId);
		//级联删除
		articleCommentMapper.deleteComments(articleCommentMapper.getAllByArticle(articleId));
	}
	/**
	 * 移动到回收站
	 * @param articleId
	 * @param token
	 * @throws Exception
	 */
	public void moveToRecycle(Integer articleId, String token) throws Exception{
		//校验token
			if (!authorityDisposer.validate(token)) {
				throw new InvalidTokenException("token过期");
			}
			ArticleBase bean = articleMapper.getArticleById(articleId);
			if (bean==null) {
				throw new NoDataException("No such article with id(" + articleId + ")");
			}
			//更新状态
			bean.setArticleState(1);
			articleMapper.updateArticle(bean);
	}
	/**
	 * 移出回收站
	 * @param articleId
	 * @param token
	 * @throws Exception
	 */
	public void moveOutRecycle(Integer articleId, String token) throws Exception{
		//校验token
			if (!authorityDisposer.validate(token)) {
				throw new InvalidTokenException("token过期");
			}
			ArticleBase bean = articleMapper.getArticleById(articleId);
			if (bean==null) {
				throw new NoDataException("No such article with id(" + articleId + ")");
			}
			//更新状态
			bean.setArticleState(0);
			articleMapper.updateArticle(bean);
	}
	public List<ArticleComment> getArticleComments(Integer articleId) throws Exception{
		List<ArticleComment> topComms = articleCommentMapper.getTopCommByArticle(articleId);
		//遍历获得二级回复
		for (ArticleComment topComm : topComms) {
			topComm.setChildComms(articleCommentMapper.getSecondComm(topComm.getCommId()));
		}
		return topComms;
	}
}
