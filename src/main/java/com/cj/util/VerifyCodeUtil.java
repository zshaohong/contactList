package com.cj.util;

/**
 * Created by QQ猴王 on 2017/6/5.
 */
public class VerifyCodeUtil {

    private static int getRandom(int count){
        return (int) Math.round(Math.random()*(count));
    }

    private static String string = "1234567890";

    public static String getRandomString(int length){
        StringBuffer sb = new StringBuffer();
        int len= string.length();
        for (int i = 0;i<length;i++){
            sb.append(string.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String s = getRandomString(6);
        System.out.println(s);
    }
}
