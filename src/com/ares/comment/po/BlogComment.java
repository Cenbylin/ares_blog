package com.ares.comment.po;

import java.util.Date;
import java.util.List;

import com.ares.article.po.ArticleComment;

public class BlogComment {
    private Integer commId;

    private Integer parentId;

    private String personName;

    private String personEmail;
    
    private String personUrl;

    private String commContent;

    private Date createTime;

    private Integer commSort;

    private String commIp;
    
    private List<ArticleComment> childComms;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail == null ? null : personEmail.trim();
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent == null ? null : commContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCommSort() {
        return commSort;
    }

    public void setCommSort(Integer commSort) {
        this.commSort = commSort;
    }

    public String getCommIp() {
        return commIp;
    }

    public void setCommIp(String commIp) {
        this.commIp = commIp == null ? null : commIp.trim();
    }

	public String getPersonUrl() {
		return personUrl;
	}

	public void setPersonUrl(String personUrl) {
		this.personUrl = personUrl;
	}

	public List<ArticleComment> getChildComms() {
		return childComms;
	}

	public void setChildComms(List<ArticleComment> childComms) {
		this.childComms = childComms;
	}
}