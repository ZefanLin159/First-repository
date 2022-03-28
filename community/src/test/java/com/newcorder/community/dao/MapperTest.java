package com.newcorder.community.dao;


import com.newcorder.community.CommunityApplication;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.entity.User;
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
        int i = userMapper.updateStatus(101, 1);
//        http://images.nowcoder.com/head/100t.png
        int i1 = userMapper.updateHeader(101, "http://images.nowcoder.com/head/100t.png");
        userMapper.updatePassword(101, "390ba5f6b5f18dd4c63d7cda170a0c74");

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
}
