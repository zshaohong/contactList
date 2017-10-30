package com.cj.common;

/**
 * Created by QQ猴王 on 2017/6/5.
 */
public class Const {

    public static final String CURRENT_USER = "currentUser";
    public static final String USERNAME = "username";
    public static final String EMAIL = "email";







    public enum EmailTypeEnum{

        FORGET_PASSWORD(1,"重置密码"),
        REGISTER(2,"注册账号");
        private String value;
        private int code;

        EmailTypeEnum(int code, String value) {
            this.code = code;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getCode() {
            return code;
        }
    }


}
