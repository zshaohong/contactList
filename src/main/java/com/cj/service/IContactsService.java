package com.cj.service;

import com.cj.common.ServerResponse;
import com.cj.pojo.Contacts;
import com.cj.vo.ContactListVo;
import com.cj.vo.ContactVo;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
public interface IContactsService {


    ServerResponse<String> addContact(Integer userId, ContactVo contactVo);

    ServerResponse<String> updateContact(Integer userId, ContactVo contactVo);

    ServerResponse<String> deleteContact(Integer userId, Integer contactId);

    ContactListVo getList(Integer userId);
}
