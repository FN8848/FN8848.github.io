package com.hd.service;

import com.hd.dao.BabyDao;
import com.hd.model.Baby;

import java.util.List;

/**
 * 收藏
 */
public class BabyService {
    BabyDao babyDao = new BabyDao();

    //添加收藏
    public void insertBaby(int user_id, int post_id, String post_title) {
        babyDao.insertBaby(user_id, post_id, post_title);
    }

    //根据用户id获取收藏列表
    public List<Baby> selectBabyListByUserId(int user_id) {
        return babyDao.selectBabyListByUserId(user_id);
    }

    //根据收藏id删除已收藏的帖子
    public void deleteBabyById(int id) {
        babyDao.deleteBabyById(id);
    }
}
