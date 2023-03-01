package com.hd.model;

/**
 * 评论
 */
public class Comment {
    private int id;//评论主键
    private String user_username;//用户名
    private String say;//评论内容
    private int post_id;//帖子id

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user_username='" + user_username + '\'' +
                ", say='" + say + '\'' +
                ", post_id=" + post_id +
                '}';
    }

    public Comment() {
    }

    public Comment(int id, String user_username, String say, int post_id) {
        this.id = id;
        this.user_username = user_username;
        this.say = say;
        this.post_id = post_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_username() {
        return user_username;
    }

    public void setUser_username(String user_username) {
        this.user_username = user_username;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
