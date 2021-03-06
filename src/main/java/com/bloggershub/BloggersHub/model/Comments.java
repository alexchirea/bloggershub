package com.bloggershub.BloggersHub.model;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer article_id) {
        this.articleId = article_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    private String username;
    private Integer articleId;
    private String message;
    private String ip;
    private String approved;
}
