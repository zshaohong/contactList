package com.cj.vo;

import java.util.List;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
public class ContactListVo<T> {

    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
