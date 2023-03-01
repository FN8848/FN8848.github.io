package com.hd.dao;

import com.hd.model.Post;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子
 */
public class PostDao {
    //发帖
    public void insertPost(int user_id, String user_username, String title, String text, int community_id) {
        String sql = "INSERT INTO post(user_id,user_username,title,text,community_id)VALUES(?,?,?,?,?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            pstmt.setString(2,user_username);
            pstmt.setString(3, title);
            pstmt.setString(4, text);
            pstmt.setInt(5, community_id);
            pstmt.executeUpdate();
            System.out.println("PostDao发帖成功");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("PostDao发帖失败");
        }
    }

    //帖子详情: 根据id获取帖子信息
    public Post selectPostById(int id) {
        String sql = "SELECT * FROM post WHERE id=?";
        Connection connection = DBUtil.getConnection();
        Post post = new Post();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setUser_username(rs.getString("user_username"));
                post.setTitle(rs.getString("title"));
                post.setText(rs.getString("text"));
                post.setCommunity_id(rs.getInt("community_id"));//帖子对应的社区id
                post.setUser_id(rs.getInt("user_id"));
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    //首页列表:获取帖子集合
    public List<Post> selectPostList() {
        List<Post> postList = new ArrayList<>();
        String sql = "SELECT * FROM post ORDER BY id DESC";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));//帖子的 id
                post.setUser_id(rs.getInt("user_id"));//用户id
                post.setTitle(rs.getString("title"));//帖子标题
                post.setText(rs.getString("text"));//帖子内容
                post.setCommunity_id(rs.getInt("community_id"));//利用帖子外键得到社区的 id
                postList.add(post);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    //我的帖子: 根据用户id获取帖子列表
    public List<Post> selectPostListByUserId(int user_id) {
        List<Post> postList = new ArrayList<>();
        String sql = "SELECT * FROM post WHERE user_id=? ORDER BY id DESC";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));//帖子的 id
                post.setUser_id(rs.getInt("user_id"));//用户id
                post.setTitle(rs.getString("title"));//帖子标题
                post.setText(rs.getString("text"));//帖子内容
                post.setCommunity_id(rs.getInt("community_id"));//利用帖子外键得到社区的 id
                postList.add(post);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    //根据帖子的 id 删除帖子
    public void deletePostById(int id) {
        String sql = "DELETE FROM post WHERE id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("PostDao删除了一条帖子");
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //社区里面的帖子: 根据社区id查询对应的帖子列表
    public List<Post> selectPostListByCommunityId(int community_id) {
        List<Post> postList = new ArrayList<>();
        String sql = "SELECT * FROM post WHERE community_id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, community_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setId(rs.getInt("id"));//帖子id
                post.setUser_id(rs.getInt("user_id"));//用户名
                post.setTitle(rs.getString("title"));//帖子标题
                post.setText(rs.getString("text"));//帖子内容
                post.setCommunity_id(rs.getInt("community_id"));//社区id
                postList.add(post);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }
}
