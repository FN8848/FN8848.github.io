package com.hd.dao;

import com.hd.model.Baby;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 收藏
 */
public class BabyDao {
    //添加收藏
    public void insertBaby(int user_id, int post_id, String post_title) {
        String sql = "INSERT INTO baby(user_id,post_id,post_title)VALUES(?,?,?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.setInt(2, post_id);
            pstmt.setString(3, post_title);
            pstmt.executeUpdate();
            System.out.println("收藏成功");
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("收藏失败");
        }
    }

    //根据用户id获取收藏列表
    public List<Baby> selectBabyListByUserId(int user_id) {
        List<Baby> babyList = new ArrayList<>();
        String sql = "SELECT * FROM baby WHERE user_id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Baby baby = new Baby();
                baby.setId(rs.getInt("id"));//收藏主键id
                baby.setUser_id(rs.getInt("user_id"));//用户id
                baby.setPost_id(rs.getInt("post_id"));//帖子id
                baby.setPost_title(rs.getString("post_title"));//帖子标题
                babyList.add(baby);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return babyList;
    }

    //根据收藏id删除已收藏的帖子
    public void deleteBabyById(int id) {
        String sql = "DELETE FROM baby WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("BabyDao删除了一条收藏");
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
