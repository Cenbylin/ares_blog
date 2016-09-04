package com.ares.blogbase.po;

import org.codehaus.jackson.annotate.JsonIgnore;

public class BlogBase {
    private String blogName;

    private String adminNickname;
    @JsonIgnore
    private String adminPassword;

    private String gitAccount;

    private Integer showGit;

    private Integer showCv;

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName == null ? null : blogName.trim();
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname == null ? null : adminNickname.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getGitAccount() {
        return gitAccount;
    }

    public void setGitAccount(String gitAccount) {
        this.gitAccount = gitAccount == null ? null : gitAccount.trim();
    }

    public Integer getShowGit() {
        return showGit;
    }

    public void setShowGit(Integer showGit) {
        this.showGit = showGit;
    }

    public Integer getShowCv() {
        return showCv;
    }

    public void setShowCv(Integer showCv) {
        this.showCv = showCv;
    }
}