package com.hd.service;

import com.hd.dao.CommunityDao;
import com.hd.model.Community;

import java.util.List;

public class CommunityService {
    CommunityDao communityDao = new CommunityDao();

    //获取社区列表
    public List<Community> selectCommunityList() {
        return communityDao.selectCommunityList();
    }

    //首页社区: 获取社区信息: 根据 社区id 查询对应社区
    public Community selectCommunityById(int id) {
        return communityDao.selectCommunityById(id);
    }

    //我的社区: 获取社区信息: 根据 用户id 查询对应社区
    public List<Community> selectCommunityByUserId(int user_id) {
        return communityDao.selectCommunityByUserId(user_id);
    }

    //创建一个社区
    public boolean insertCommunity(String name, String intro, int user_id) {
        return communityDao.insertCommunity(name, intro, user_id);
    }
}
