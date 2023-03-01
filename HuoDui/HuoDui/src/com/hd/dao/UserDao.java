package com.hd.dao;

import com.hd.model.User;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //注册
    public void register(int number, String password, String username) {
        String sql = "INSERT INTO user(number,password,username)VALUES(?,?,?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, number);
            pstmt.setString(2, password);
            pstmt.setString(3, username);
            pstmt.executeUpdate();
            System.out.println("注册成功!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("注册失败");
        }
    }

    //登录功能
    public User login(int number, String password) {
        User user = null;
        String sql = "SELECT * FROM user WHERE number=? AND password=?";
        Connection connection = DBUtil.getConnection();
        try {

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, number);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setNumber(rs.getInt("number"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
            }
            System.out.println("userDao登录成功");
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("userDao登录失败");
        return user;
    }

    //根据账号获得用户信息
    public User selectUser(int number) {
        User user = null;
        String sql = "SELECT * FROM user WHERE number=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, number);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setNumber(rs.getInt("number"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
