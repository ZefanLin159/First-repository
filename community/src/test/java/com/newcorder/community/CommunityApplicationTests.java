package com.newcorder.community;

import com.newcorder.community.dao.AlphaDao;
import com.newcorder.community.dao.AlphaDaoHibernateImpl;
import com.newcorder.community.servlet.AlphaService;
import com.newcorder.community.servlet.AlphaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Test
    void contextLoads() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext() {
        System.out.println(applicationContext);
        AlphaDao alphaDao = applicationContext.getBean("AlphaHibernate", AlphaDao.class);
        System.out.println(alphaDao.select());
    }

    @Test
    public void testBeanManagement() {
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig() {
        SimpleDateFormat simpleDateFormatBean = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormatBean.format(new Date()));
    }

    @Autowired
    @Qualifier("AlphaHibernate")
    private AlphaDao alphaDao;

    //    测试依赖注入（DependenceInjection）
    @Test
    public void testDI() {
        System.out.println(alphaDao);
    }
}
