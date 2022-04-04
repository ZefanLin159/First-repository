package com.newcorder.community;


import com.newcorder.community.CommunityApplication;
import com.newcorder.community.dao.DiscussPostMapper;
import com.newcorder.community.dao.LoginTicketMapper;
import com.newcorder.community.dao.UserMapper;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.entity.LoginTicket;
import com.newcorder.community.entity.User;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.CommunityUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private LoginTicketMapper loginTicketDao;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);
        User user1 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user1);
        User user2 = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
//        int i = userMapper.updateStatus(101, 1);
//        http://images.nowcoder.com/head/100t.png
//        userMapper.updatePassword(101, "390ba5f6b5f18dd4c63d7cda170a0c74");
        User user = userMapper.selectById(149);

        userMapper.updatePassword(149, CommunityUtil.md5("123") + user.getSalt());
        userMapper.updateHeader(149, "http://images.nowcoder.com/head/199t.png");

    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.newcoder.com/101.png");
        user.setCreateTime(new Date());
        userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }
//        System.out.println(list);
        int row = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(row);
    }

    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketDao.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = loginTicketDao.selectByTicket("abc");
        System.out.println(loginTicket);
        loginTicketDao.updateStatus("abc", 1);
        loginTicket = loginTicketDao.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void insertDiscussPostTest() {
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(188);
        discussPost.setContent("我是小冰的小跟班");
        discussPost.setCreateTime(new Date());
        discussPost.setTitle("菜狗发言");
        discussPost.setStatus(0);
        discussPost.setScore(1700.213);
        discussPost.setType(0);
        discussPost.setCommentCount(0);
        discussPostMapper.insertDiscussPost(discussPost);
    }

    //    @Test
//    public void deleteUserTest() {
//        userMapper.deleteUser(151);
//        userMapper.deleteUser(155);
//        userMapper.deleteUser(156);
//        userMapper.deleteUser(157);
//        userMapper.deleteUser(158);
//        userMapper.deleteUser(159);
//        userMapper.deleteUser(160);
//    }
    @Test
    public void selectDiscussPostTest() {
        DiscussPost post = discussPostMapper.selectDiscussPostById(149);
        System.out.println(post);

    }
}
