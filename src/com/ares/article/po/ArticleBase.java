package com.ares.article.po;

import java.util.Date;

public class ArticleBase {
    private Integer articleId;

    private Integer articleSort;

    private String articleTitle;

    private Date createTime;

    private Integer articleState;

    private String articleIntro;

    private byte[] articleContent;

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
}