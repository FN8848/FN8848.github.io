package com.hd.model;

/**
 * 我的收藏
 */
public class Baby {
    private int id;//收藏主键
    private int user_id;//收藏者的id
    private int post_id;//帖子id
    private String post_title;//帖子标题

    @Override
    public String toString() {
        return "Baby{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", post_id=" + post_id +
                ", post_title='" + post_title + '\'' +
                '}';
    }

    public Baby() {
    }

    public Baby(int id, int user_id, int post_id, String post_title) {
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.post_title = post_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

}
