package com.newcorder.community.service;

import com.newcorder.community.dao.DiscussPostMapper;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Autowired
    private SensitiveFilter sensitiveFilter;

    public List<DiscussPost> findDiscussPosts(int userID, int offset, int limitPage) {
        return discussPostMapper.selectDiscussPosts(userID, offset, limitPage);
    }

    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }

    public int addDiscussPost(DiscussPost post) {
        if (post == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

//         排除一些标签，避免影响网页
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
        post.setContent(HtmlUtils.htmlEscape(post.getContent()));
//        过滤敏感词
        post.setTitle(sensitiveFilter.filter(post.getTitle()));
        post.setTitle(sensitiveFilter.filter(post.getContent()));

        return discussPostMapper.insertDiscussPost(post);
    }
}
