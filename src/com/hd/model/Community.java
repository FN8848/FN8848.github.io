package com.hd.model;

/**
 * 社区
 */
public class Community {
    private int id;//社区主键
    private String name;//社区名
    private String intro;//社区简介
    private int user_id;//外键,连接社区创建者的 id

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    public Community() {
    }

    public Community(int id, String name, String intro, int user_id) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.user_id = user_id;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
