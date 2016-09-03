package com.ares.article.po;

import java.util.Date;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

public class ArticleBase {
    private Integer articleId;

    private Integer articleSort;

    private String articleTitle;

    private Date createTime;

    private Integer articleState;

    private String articleIntro;
    @JsonIgnore
    private byte[] articleContent;
    
    private Integer commentNum;
    
    private Integer shareNum;
    
    private Integer watchNum;
    
    private List<ArticleComment> articleComms;
    
    private List<ArticleTag> articleTags;

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(Integer articleSort) {
        this.articleSort = articleSort;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle == null ? null : articleTitle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getArticleState() {
        return articleState;
    }

    public void setArticleState(Integer articleState) {
        this.articleState = articleState;
    }

    public String getArticleIntro() {
        return articleIntro;
    }

    public void setArticleIntro(String articleIntro) {
        this.articleIntro = articleIntro == null ? null : articleIntro.trim();
    }

    public byte[] getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(byte[] articleContent) {
        this.articleContent = articleContent;
    }

	public List<ArticleComment> getArticleComms() {
		return articleComms;
	}

	public void setArticleComms(List<ArticleComment> articleComms) {
		this.articleComms = articleComms;
	}

	public Integer getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}

	public Integer getShareNum() {
		return shareNum;
	}

	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}

	public Integer getWatchNum() {
		return watchNum;
	}

	public void setWatchNum(Integer watchNum) {
		this.watchNum = watchNum;
	}

	public List<ArticleTag> getArticleTags() {
		return articleTags;
	}

	public void setArticleTags(List<ArticleTag> articleTags) {
		this.articleTags = articleTags;
	}
}