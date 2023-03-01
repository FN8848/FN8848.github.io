package com.hd.dao;

import com.hd.model.Community;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 社区
 */
public class CommunityDao {
    //首页:查询社区列表
    public List<Community> selectCommunityList() {
        List<Community> communityList = new ArrayList<>();
        String sql = "SELECT * FROM community";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Community community = new Community();
                community.setId(rs.getInt("id"));
                community.setName(rs.getString("name"));
                community.setIntro(rs.getString("intro"));
                community.setUser_id(rs.getInt("user_id"));
                communityList.add(community);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return communityList;
    }

    //首页社区: 获取社区信息: 根据 社区id 查询对应社区
    public Community selectCommunityById(int id) {
        Community community = null;
        String sql = "SELECT * FROM community WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                community = new Community();
                community.setId(rs.getInt("id"));
                community.setName(rs.getString("name"));
                community.setIntro(rs.getString("intro"));
                community.setUser_id(rs.getInt("user_id"));
            }
            return community;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return community;
    }

    //我的社区: 获取社区信息: 根据 用户id 查询社区列表
    public List<Community> selectCommunityByUserId(int user_id) {
        List<Community> communityList = new ArrayList<>();
        String sql = "SELECT * FROM community WHERE user_id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Community community = new Community();
                community.setId(rs.getInt("id"));
                community.setName(rs.getString("name"));
                community.setIntro(rs.getString("intro"));
                community.setUser_id(rs.getInt("user_id"));
                communityList.add(community);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return communityList;
    }

    //创建一个社区
    public boolean insertCommunity(String name, String intro, int user_id) {
        String sql = "INSERT INTO community(name,intro,user_id)VALUES(?,?,?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, intro);
            pstmt.setInt(3, user_id);
            pstmt.executeUpdate();
            System.out.println("CommunityDao:社区创建成功");
            pstmt.close();
            connection.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("CommunityDao:社区创建失败");
        return false;
    }
}
