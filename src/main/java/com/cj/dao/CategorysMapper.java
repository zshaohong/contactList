package com.cj.dao;

import com.cj.pojo.Categorys;
import org.apache.ibatis.annotations.Param;

public interface CategorysMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Categorys record);

    int insertSelective(Categorys record);

    Categorys selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Categorys record);

    int updateByPrimaryKey(Categorys record);

    int deleteByUserId(Integer userId);

    Categorys selectByUserIdCategoryId(@Param("userId") Integer userId,@Param("categoryId") Integer categoryId);

    Categorys selectByNameMark(@Param("categoryName") String categoryName,@Param("categoryMark")String categoryMark);

}