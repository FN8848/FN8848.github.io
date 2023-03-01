package com.hd.dao;

import com.hd.model.Comment;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 评论
 */
public class CommentDao {

    //发表一条评论
    public void insertComment(String user_username, String say, int post_id) {
        String sql = "INSERT INTO comment(user_username,say,post_id)VALUES(?,?,?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user_username);
            pstmt.setString(2, say);
            pstmt.setInt(3, post_id);
            pstmt.executeUpdate();
            System.out.println("PostDao评论成功");
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("PostDao评论失败");
        }
    }

    //获取某个帖子的评论列表
    public List<Comment> selectCommentListByPostId(int post_id) {
        List<Comment> commentList = new ArrayList<>();
        String sql = "SELECT * FROM comment WHERE post_id=?";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, post_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Comment comment = new Comment();
                comment.setId(rs.getInt("id"));//评论主键id
                comment.setUser_username(rs.getString("user_username"));//用户名
                comment.setSay(rs.getString("say"));//评论内容
                comment.setPost_id(rs.getInt("post_id"));//评论所在帖子的id
                commentList.add(comment);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }
}
