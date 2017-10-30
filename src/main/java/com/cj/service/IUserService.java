package com.cj.service;

import com.cj.common.ServerResponse;
import com.cj.pojo.User;

/**
 * Created by QQ猴王 on 2017/6/15.
 */
public interface IUserService {

    ServerResponse<String> register(User user);

    ServerResponse<User> login(String username, String password);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> resetPassword(String passwordNew, User user);

    ServerResponse<String> deleteSelf(Integer userId);
}
