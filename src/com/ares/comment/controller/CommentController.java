package com.ares.comment.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ares.comment.po.BlogComment;
import com.ares.comment.service.BlogCommentService;

/**
 * 留言控制器（RESTful）
 * @author Cenby7
 *
 */
@Controller
@RequestMapping("comment")
public class CommentController {
	@Autowired
	BlogCommentService blogCommentService;
	/**
	 * 发表留言
	 * @param blogComment
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> addComment(BlogComment blogComment) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		blogCommentService.addComment(blogComment);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 删除留言
	 * @param commId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{commId}", method=RequestMethod.DELETE)
	public @ResponseBody HashMap<String, Object> deleteComment(@PathVariable("commId") Integer commId, 
			String token) throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		blogCommentService.deleteArticle(commId, token);
		//异常交由统一异常处理
		return res;
	}
	/**
	 * 获得留言
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getComments() throws Exception{
		HashMap<String, Object> res = new HashMap<String, Object>();
		res.put("state", true);
		res.put("comments", blogCommentService.getBlogComments());
		//异常交由统一异常处理
		return res;
	}
	
}
