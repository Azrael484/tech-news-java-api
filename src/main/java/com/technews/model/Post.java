package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
@Table(name = "post")

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String postUrl;
    @Transient
    private String userName;
    @Transient
    private int voteCount;
    private Integer userId;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();
    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Post() {
    }

    public Post(Integer id, String title, String postUrl, String userName, int voteCount, Integer userId, Date postedAt, Date updatedAt, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.postUrl = postUrl;
        this.userName = userName;
        this.voteCount = voteCount;
        this.userId = userId;
        this.postedAt = postedAt;
        this.updatedAt = updatedAt;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public String getUserName() {
        return userName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post post)) return false;
        return voteCount == post.voteCount && Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(postUrl, post.postUrl) && Objects.equals(userName, post.userName) && Objects.equals(userId, post.userId) && Objects.equals(postedAt, post.postedAt) && Objects.equals(updatedAt, post.updatedAt) && Objects.equals(comments, post.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, postUrl, userName, voteCount, userId, postedAt, updatedAt, comments);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", postUrl='" + postUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", voteCount=" + voteCount +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                ", comments=" + comments +
                '}';
    }
}
