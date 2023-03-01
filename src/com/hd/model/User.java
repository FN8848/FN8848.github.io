package com.hd.model;

/**
 * 用户
 */
public class User {
    private int id;//用户主键
    private int number;//账号(数字)
    private String password;//密码
    private String username;//用户昵称

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number=" + number +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public User() {
    }

    public User(int id, int number, String password, String username) {
        this.id = id;
        this.number = number;
        this.password = password;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
