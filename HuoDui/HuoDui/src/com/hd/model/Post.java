package com.hd.model;

/**
 * 帖子
 */
public class Post {
    private int id;//帖子id
    private int user_id;//用户id
    private String user_username;//用户名
    private String title;//标题
    private String text;//内容
    private int community_id;//帖子所属社区的 id

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", user_username='" + user_username + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", community_id=" + community_id +
                '}';
    }

    public Post() {
    }

    public Post(int id, int user_id, String user_username, String title, String text, int community_id) {
        this.id = id;
        this.user_id = user_id;
        this.user_username = user_username;
        this.title = title;
        this.text = text;
        this.community_id = community_id;
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

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }
}
