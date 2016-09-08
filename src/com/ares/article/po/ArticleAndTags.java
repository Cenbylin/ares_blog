package com.ares.article.po;

import java.util.List;

public class ArticleAndTags {
	private int articleId;
	private List<Integer> tagIds;
	
	public ArticleAndTags(int articleId, List<Integer> tagIds) {
		super();
		this.articleId = articleId;
		this.tagIds = tagIds;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public List<Integer> getTagIds() {
		return tagIds;
	}
	public void setTagIds(List<Integer> tagIds) {
		this.tagIds = tagIds;
	}
}
