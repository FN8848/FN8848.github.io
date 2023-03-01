package com.hd.model;

import java.util.List;

/**
 * 详情
 * 包含：用户、社区、帖子的信息
 * 主要展示帖子的信息
 */
public class Detail<T> {
    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
