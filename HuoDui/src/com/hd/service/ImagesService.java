package com.hd.service;

import com.hd.dao.ImagesDao;
import com.hd.model.Images;

import java.util.List;

/**
 * 图片
 */
public class ImagesService {
    ImagesDao imagesDao = new ImagesDao();

    //获取图片列表
    public List<Images> selectImagesList() {
        return imagesDao.selectImagesList();
    }

    //上传图片
    public void insertImages(String imagesUrl) {
        imagesDao.insertImages(imagesUrl);
    }
}
