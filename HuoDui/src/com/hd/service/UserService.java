package com.hd.service;

import com.hd.dao.UserDao;
import com.hd.model.User;

public class UserService {
    UserDao userDao = new UserDao();

    //注册
    public void register(int number, String password, String username) {
        userDao.register(number, password, username);
    }

    //登录功能
    public User login(int number, String password) {
        return userDao.login(number, password);
    }

    //根据账号获取用户信息
    public User selectUser(int number) {
        return userDao.selectUser(number);
    }

    //修改用户名
    public void updateUserName(String username, int id) {
        userDao.updateUserName(username, id);
    }

    //修改密码
    public void updateUserPassWord(String password, int id) {
        userDao.updateUserPassWord(password, id);
    }
    //删除用户
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
}
