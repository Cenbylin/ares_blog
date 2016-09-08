package com.ares.article.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.article.po.ArticleBase;
import com.ares.article.service.ArticleService;

/**
 * 博文控制器（RESTful）
 * @author Cenby7
 *
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired
	ArticleService articleService;
	/**
	 * 获得文章列表
	 * @param pageNum
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/list/{pageNum}")
	public @ResponseBody HashMap<String, Object> getArticleList(@PathVariable("pageNum") int pageNum) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("articleList", articleService.getArticles(pageNum));
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 获得文章内容
	 * 响应文章详情的json
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value="/{articleId}", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getArticle(@PathVariable("articleId") int articleId) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("articleDetail", articleService.getArticleById(articleId));
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 更新文章内容
	 * @param articleId
	 * @param token
	 * @param articleBase
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{articleId}", method=RequestMethod.PUT)
	public @ResponseBody HashMap<String, Object> updateArticle(@PathVariable("articleId") int articleId, 
			@RequestParam(value="token") String token, ArticleBase articleBase) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		//更新
		articleService.updateArticle(articleBase, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 发表文章
	 * @param articleId
	 * @param token
	 * @param articleBase
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> addArticle(@RequestParam(value="token") String token, 
			ArticleBase articleBase) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		//更新
		articleService.addArticle(articleBase, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 移入回收站
	 * @param articleId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/recycle", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> moveToRecycle(@PathVariable("articleId") int articleId, 
			@RequestParam(value="token") String token) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		articleService.moveToRecycle(articleId, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 移出回收站
	 * @param articleId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/recycle", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> moveOutRecycle(@PathVariable("articleId") int articleId, 
			@RequestParam(value="token") String token) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		articleService.moveOutRecycle(articleId, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 删除文章
	 * @param articleId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{articleId}", method=RequestMethod.DELETE)
	public @ResponseBody HashMap<String, Object> deleteArticle(@PathVariable("articleId") int articleId, 
			@RequestParam(value="token") String token) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		articleService.deleteArticle(articleId, token);
		//异常交由统一异常处理
		return res;
	}
}
