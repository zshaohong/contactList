package com.cj.service;

import com.cj.common.ServerResponse;
import com.cj.pojo.Categorys;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
public interface ICategorysService {

    ServerResponse<String> addCategory(Integer userId, Categorys categorys);

    ServerResponse<String> deleteCategory(Integer userId,Integer categoryId);

    ServerResponse<String> updateCategory(Integer userId,Categorys categorys);
}
