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
            pstmt.close();
            connection.close();
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
            rs.close();
            pstmt.close();
            connection.close();
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
            rs.close();
            pstmt.close();
            connection.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //修改用户名
    public void updateUserName(String username, int id) {
        String sql = "UPDATE user SET username=? WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改密码
    public void updateUserPassWord(String password, int id) {
        String sql = "UPDATE user SET password=? WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除用户
    public void deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
