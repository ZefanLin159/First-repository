package com.newcorder.community.service;

import com.newcorder.community.dao.DiscussPostMapper;
import com.newcorder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPosts(int userID, int offset, int limitPage) {
        return discussPostMapper.selectDiscussPosts(userID, offset, limitPage);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
