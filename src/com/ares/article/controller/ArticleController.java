package com.ares.article.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
