package com.hd.service;

import com.hd.dao.PostDao;
import com.hd.model.Post;

import java.util.List;

public class PostService {
    PostDao postDao = new PostDao();

    //发帖
    public void insertPost(int user_id, String user_username, String title, String text, int community_id) {
        postDao.insertPost(user_id, user_username, title, text, community_id);
    }

    //通过帖子id获取帖子信息
    public Post selectPostById(int post_id) {
        return postDao.selectPostById(post_id);
    }

    //首页帖子列表
    public List<Post> selectPostList() {
        return postDao.selectPostList();
    }

    //我的帖子: 根据用户id获取帖子列表
    public List<Post> selectPostListByUserId(int user_id) {
        return postDao.selectPostListByUserId(user_id);
    }

    //删除帖子
    public void deletePostById(int id) {
        postDao.deletePostById(id);
    }

    //社区里面的帖子: 根据社区id查询对应的帖子列表
    public List<Post> selectPostListByCommunityId(int community_id) {
        return postDao.selectPostListByCommunityId(community_id);
    }
}
