package com.cj.service.Impl;

import com.cj.common.ServerResponse;
import com.cj.dao.CategorysMapper;
import com.cj.dao.ContactsMapper;
import com.cj.pojo.Categorys;
import com.cj.pojo.Contacts;
import com.cj.service.IContactsService;
import com.cj.vo.ContactListVo;
import com.cj.vo.ContactVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
@Service("iContactsService")
public class ContactsServiceImpl implements IContactsService {

    @Autowired
    private ContactsMapper contactsMapper;
    @Autowired
    private CategorysMapper categorysMapper;

    public ServerResponse<String> addContact(Integer userId, ContactVo contactVo){

        String categoryName = contactVo.getCategory();
        String categoryMark = contactVo.getCategoryMark();
        Contacts contacts = new Contacts();
        contacts.setId(contactVo.getId());
        contacts.setContactName(contactVo.getContactName());
        contacts.setContactSex(contactVo.getContactSex());
        contacts.setContactPhone(contactVo.getContactPhone());
        contacts.setContactEmail(contactVo.getContactEmail());
        contacts.setContactDesc(contactVo.getContactDesc());
        Categorys categorys1 = categorysMapper.selectByNameMark(categoryName,categoryMark);

        if(categorys1 == null){
            Categorys categorys = new Categorys();
            categorys.setUserId(userId);
            categorys.setCategoryMark(categoryMark);
            categorys.setCategorysName(categoryName);
            categorys.setUserId(userId);
            categorysMapper.insertSelective(categorys);
            contacts.setCategorysId((categorysMapper.selectByNameMark(categoryName, categoryMark)).getId());
        }
        else {
            contacts.setCategorysId(categorys1.getId());
        }
        contacts.setUserId(userId);
        int resultCount = contactsMapper.insertSelective(contacts);
        if(resultCount>0){
            return ServerResponse.createBySuccessMessage("新建联系人成功");
        }
        return ServerResponse.createByErrorMessage("新建联系人失败");
    }

    public ServerResponse<String> updateContact(Integer userId,ContactVo contactVo){
        String categoryName = contactVo.getCategory();
        String categoryMark = contactVo.getCategoryMark();
        Contacts contacts = new Contacts();
        contacts.setId(contactVo.getId());
        contacts.setContactName(contactVo.getContactName());
        contacts.setContactSex(contactVo.getContactSex());
        contacts.setContactPhone(contactVo.getContactPhone());
        contacts.setContactEmail(contactVo.getContactEmail());
        contacts.setContactDesc(contactVo.getContactDesc());
        Categorys categorys1 = categorysMapper.selectByNameMark(categoryName,categoryMark);
        if(categorys1 == null){
            Categorys categorys = new Categorys();
            categorys.setUserId(userId);
            categorys.setCategorysName(categoryName);
            categorys.setCategoryMark(categoryMark);
            categorysMapper.insertSelective(categorys);
            contacts.setCategorysId((categorysMapper.selectByNameMark(categoryName, categoryMark)).getId());
        }else {
            contacts.setCategorysId(categorys1.getId());
        }
        int resultCount = contactsMapper.updateByPrimaryKeySelective(contacts);
        if(resultCount>0){
            return ServerResponse.createBySuccessMessage("更新联系人成功");
        }
        return ServerResponse.createByErrorMessage("更新联系人失败");
    }

    public ServerResponse<String> deleteContact(Integer userId,Integer contactId){
        Contacts contacts = contactsMapper.selectByUserIdContactId(userId, contactId);
        if (contacts == null){
            return ServerResponse.createByErrorMessage("删除联系人失败");
        }
        int resultCount = contactsMapper.deleteByPrimaryKey(contactId);
        if (resultCount>0){
            return ServerResponse.createBySuccessMessage("删除联系人成功");
        }
        return ServerResponse.createByErrorMessage("删除联系人失败");
    }

    public ContactListVo getList(Integer userId) {
        if (userId == null) {
            return null;
        }
        List<Contacts> contactsList = contactsMapper.selectByUserId(userId);
        List<ContactVo> contactVoList = Lists.newArrayList();
        for (Contacts contacts:contactsList){
            ContactVo contactVo = this.assembleContactVo(contacts);
            contactVoList.add(contactVo);
        }
        ContactListVo contactListVo = new ContactListVo();
        contactListVo.setData(contactVoList);
        return contactListVo;
    }

    private ContactVo assembleContactVo(Contacts contacts){
        ContactVo contactVo = new ContactVo();
        contactVo.setId(contacts.getId());
        Categorys categorys = categorysMapper.selectByPrimaryKey(contacts.getCategorysId());
        contactVo.setCategory(categorys.getCategorysName());
        contactVo.setContactName(contacts.getContactName());
        contactVo.setContactSex(contacts.getContactSex());
        contactVo.setContactPhone(contacts.getContactPhone());
        contactVo.setContactEmail(contacts.getContactEmail());
        contactVo.setContactDesc(contacts.getContactDesc());
        if (categorys.getCategoryMark()==null){
            contactVo.setCategoryMark("无");
        }else {
            contactVo.setCategoryMark(categorys.getCategoryMark());
        }

        return contactVo;
    }

}
