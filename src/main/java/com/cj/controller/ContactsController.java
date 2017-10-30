package com.cj.controller;

import com.cj.common.Const;
import com.cj.common.ResponseCode;
import com.cj.common.ServerResponse;
import com.cj.pojo.Contacts;
import com.cj.pojo.User;
import com.cj.service.IContactsService;
import com.cj.vo.ContactListVo;
import com.cj.vo.ContactVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
@Controller
@RequestMapping("/contact/")
public class ContactsController {

    @Autowired
    private IContactsService iContactsService;

    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> add(HttpSession session, @RequestBody ContactVo contactVo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iContactsService.addContact(user.getId(),contactVo);
    }


    @RequestMapping(value = "delete.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> delete(HttpSession session,Integer contactId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iContactsService.deleteContact(user.getId(),contactId);
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> update(HttpSession session, @RequestBody ContactVo contactVo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iContactsService.updateContact(user.getId(),contactVo);
    }

    @RequestMapping(value = "getContactList.do",method = RequestMethod.GET)
    @ResponseBody
    public ContactListVo list(HttpSession session){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return null;
        }
        return iContactsService.getList(user.getId());

    }
}
