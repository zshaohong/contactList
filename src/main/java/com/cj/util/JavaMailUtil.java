package com.cj.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by QQ猴王 on 2017/6/5.
 */
public class JavaMailUtil {

    private static final Logger logger = LoggerFactory.getLogger(JavaMailUtil.class);

    /**
     * 发送邮件工具类:通过sina邮件发送,因为具有ssl加密,采用的是smtp协议
     * @param recipients 收件人:支持群发
     * @param emailSubject 邮件的主题
     * @param emailContent 邮件的内容
     * @return
     */
    public static int sendEmail(String[] recipients,String emailSubject,String emailContent){



        int res=0;

        try {
            //跟smtp服务器建立一个连接
            Properties p = new Properties();
            //设置邮件服务器主机名
            p.setProperty("mail.host",PropertiesUtil.getProperty("mail.host"));
            //发送服务器需要身份验证,要采用指定用户名密码的方式去认证
            p.setProperty("mail.smtp.auth", "true");
            //发送邮件协议名称
            p.setProperty("mail.transport.protocol", "smtp");

            //开启SSL加密，否则会失败
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            p.put("mail.smtp.ssl.enable", "true");
            p.put("mail.smtp.ssl.socketFactory", sf);

            // 创建session
            Session session = Session.getDefaultInstance(p, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //:第一个参数为邮箱账号,第二个为授权码
                    PasswordAuthentication pa = new PasswordAuthentication(PropertiesUtil.getProperty("mail.username"),PropertiesUtil.getProperty("mail.password"));
                    return pa;
                }
            });

            //设置打开调试状态
            session.setDebug(true);

            //可以发送几封邮件:可以在这里 for循环多次
            //声明一个Message对象(代表一封邮件),从session中创建
            MimeMessage msg = new MimeMessage(session);
            //邮件信息封装
            //1发件人
            msg.setFrom(new InternetAddress(PropertiesUtil.getProperty("mail.sender","Lei")));

            //2收件人:可以多个
            //一个的收件人
            //msg.setRecipient(RecipientType.TO, new InternetAddress("linsenzhong@126.com"));

            InternetAddress[] receptientsEmail=new InternetAddress[recipients.length];
            for(int i=0;i<recipients.length;i++){
                receptientsEmail[i]=new InternetAddress(recipients[i]);
            }

            //多个收件人
            msg.setRecipients(RecipientType.TO,receptientsEmail);

            //3邮件内容:主题、内容
            msg.setSubject(emailSubject);
            //msg.setContent("Hello, 我是debug!!!", );//纯文本
            msg.setContent(emailContent,PropertiesUtil.getProperty("mail.emailContenTypeByHtml","text/html;charset=utf-8"));//发html格式的文本
            //发送动作
            logger.info("开始发送邮件：");
            Transport.send(msg);
            logger.info("邮件发送成功。");
            res=1;

        } catch (Exception e) {
            logger.info("邮件发送失败：",e);

            res=0;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {

        String[] recipients ={"2604375326@qq.com","1056824931@qq.com"};
        String emailSubject = "注册邮件";
        String emailContent = "祝你国庆节快乐,欢迎来我的blog: <a href='http://blog.csdn.net/u013871100'>我的blog</a>,!";

        int res=sendEmail( recipients, emailSubject, emailContent);

        System.out.println("\n发送结果:"+res);
    }
}
