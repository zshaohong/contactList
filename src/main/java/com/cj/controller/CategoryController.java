package com.cj.controller;

import com.cj.common.Const;
import com.cj.common.ResponseCode;
import com.cj.common.ServerResponse;
import com.cj.pojo.Categorys;
import com.cj.pojo.User;
import com.cj.service.ICategorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
@Controller
@RequestMapping("/category/")
public class CategoryController {

    @Autowired
    private ICategorysService iCategorysService;


    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> add(HttpSession session, Categorys categorys){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCategorysService.addCategory(user.getId(),categorys);
    }

    @RequestMapping(value = "delete.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> delete(HttpSession session,Integer categoryId){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCategorysService.deleteCategory(user.getId(),categoryId);
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> update(HttpSession session,Categorys categorys){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return iCategorysService.updateCategory(user.getId(),categorys);
    }
}
