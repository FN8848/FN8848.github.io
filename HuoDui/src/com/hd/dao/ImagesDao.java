package com.hd.dao;

import com.hd.model.Images;
import com.hd.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 图片
 */
public class ImagesDao {
    //获取图片列表
    public List<Images> selectImagesList() {
        List<Images> imagesList = new ArrayList<>();
        String sql = "SELECT * FROM images";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Images images = new Images();
                images.setId(rs.getInt("id"));
                images.setImagesUrl(rs.getString("imagesUrl"));
                imagesList.add(images);
            }
            rs.close();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return imagesList;
    }

    //添加图片
    public void insertImages(String imagesUrl) {
        String sql = "INSERT INTO images(imagesUrl)VALUES(?)";
        Connection connection = DBUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, imagesUrl);
            pstmt.executeUpdate();
            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
