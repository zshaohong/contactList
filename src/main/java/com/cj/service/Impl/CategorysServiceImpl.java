package com.cj.service.Impl;

import com.cj.common.ServerResponse;
import com.cj.dao.CategorysMapper;
import com.cj.pojo.Categorys;
import com.cj.service.ICategorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
@Service("iCategoryService")
public class CategorysServiceImpl implements ICategorysService {

    @Autowired
    private CategorysMapper categorysMapper;

    public ServerResponse<String> addCategory(Integer userId, Categorys categorys) {
        categorys.setUserId(userId);
        int resultCount = categorysMapper.insert(categorys);
        if (resultCount > 0) {
            return ServerResponse.createBySuccessMessage("新增联系人类别成功");
        }
        return ServerResponse.createByErrorMessage("新增联系人类别失败");
    }

    public ServerResponse<String> deleteCategory(Integer userId,Integer categoryId){
        Categorys categorys = categorysMapper.selectByUserIdCategoryId(userId, categoryId);
        if (categorys == null){
            return ServerResponse.createByErrorMessage("没有该类别");
        }
        int resultCount = categorysMapper.deleteByPrimaryKey(categoryId);
        if (resultCount>0){
            return ServerResponse.createBySuccessMessage("删除联系人类别成功");
        }
        return ServerResponse.createByErrorMessage("删除联系人类别失败");
    }

    public ServerResponse<String> updateCategory(Integer userId,Categorys categorys){
        Categorys categorys1 = categorysMapper.selectByUserIdCategoryId(userId, categorys.getId());
        if (categorys1 == null){
            return ServerResponse.createByErrorMessage("没有该类别");
        }
        int resultCount = categorysMapper.updateByPrimaryKeySelective(categorys);
        if (resultCount>0){
            return ServerResponse.createBySuccessMessage("更改联系人类别信息成功");
        }
        return ServerResponse.createByErrorMessage("更改联系人类别信息失败");
    }
}
