package com.hd.service;

import com.hd.dao.CommentDao;
import com.hd.model.Comment;

import java.util.List;

/**
 * 评论
 */
public class CommentService {
    CommentDao commentDao = new CommentDao();

    //在帖子里添加评论
    public void insertComment(String user_username, String say, int post_id) {
        commentDao.insertComment(user_username, say, post_id);
    }

    //获取某个帖子的评论列表
    public List<Comment> selectCommentListByPostId(int post_id) {
        return commentDao.selectCommentListByPostId(post_id);
    }

}
