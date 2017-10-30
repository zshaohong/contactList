package com.cj.dao;

import com.cj.pojo.Contacts;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contacts record);

    int insertSelective(Contacts record);

    Contacts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Contacts record);

    int updateByPrimaryKey(Contacts record);

    int deleteByUserId(Integer userId);

    Contacts selectByUserIdContactId(@Param("userId") Integer userId,@Param("contactId")Integer contactId);

    List<Contacts> selectByUserId(int userId);
}