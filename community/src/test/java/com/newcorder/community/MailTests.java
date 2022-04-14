package com.newcorder.community;

//import com.newcorder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
//    @Autowired
//    private MailClient client;

    @Autowired //注入模板引擎类
    private TemplateEngine templateEngine;

//    @Test
//    public void testTextMail() {
//        client.sendMail("915654746@qq.com", "TEST", "Hello");
//    }
//
//    @Test
//    public void testHtmlMail() {
//        Context context = new Context(); //thymeleaf的模板引擎
//        context.setVariable("username", "fan");
//        String content = templateEngine.process("mail/demo", context);
//        System.out.println(context);
//        client.sendMail("915654746@qq.com", "HTML", content);
//
//    }
}
