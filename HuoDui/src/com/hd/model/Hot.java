package com.hd.model;

/**
 * 热门帖子
 */
public class Hot {
    private int id;//帖子主键
    private String post_title;//帖子标题
    private int post_id;//帖子id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public Hot() {
    }

    public Hot(int id, String post_title, int post_id) {
        this.id = id;
        this.post_title = post_title;
        this.post_id = post_id;
    }
}
