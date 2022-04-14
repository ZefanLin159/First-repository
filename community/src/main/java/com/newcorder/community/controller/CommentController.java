package com.newcorder.community.controller;

import com.newcorder.community.enent.EventProducer;
import com.newcorder.community.entity.Comment;
import com.newcorder.community.entity.DiscussPost;
import com.newcorder.community.entity.Event;
import com.newcorder.community.service.CommentService;
import com.newcorder.community.service.DiscussPostService;
import com.newcorder.community.util.CommunityConstant;
import com.newcorder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/comment")
public class CommentController implements CommunityConstant {
    private final CommentService commentService;

    private final HostHolder hostHolder;

    private final EventProducer eventProducer;

    private final DiscussPostService discussPostService;

    public CommentController(CommentService commentService, HostHolder hostHolder, EventProducer eventProducer, DiscussPostService discussPostService) {
        this.commentService = commentService;
        this.hostHolder = hostHolder;
        this.eventProducer = eventProducer;
        this.discussPostService = discussPostService;
    }

    @RequestMapping(value = "/addComment/{discussPostId}", method = RequestMethod.POST)
    public String addComment(@PathVariable("discussPostId") int discussPostId, Comment comment) {
        comment.setUserId(hostHolder.getUser().getId());
        comment.setStatus(0);
        comment.setCreateTime(new Date());
        commentService.addComment(comment);

//        触发评论事件
        Event event = new Event().setTopic(TOPIC_COMMENT)
                .setUserId(hostHolder.getUser().getId())
                .setEntityType(comment.getEntityType())
                .setEntityId(comment.getEntityId())
                .setData("postId", discussPostId);
//        看看是给谁做评论，查看comment的entityType
        if (comment.getEntityType() == ENTITY_TYPE_POST) {
            DiscussPost target = discussPostService.findDiscussPost(comment.getEntityId());
            event.setEntityUserid(target.getUserId());
        } else if (comment.getEntityType() == ENTITY_TYPE_COMMENT) {
            Comment target = commentService.findCommentById(comment.getEntityId());
            event.setEntityUserid(target.getUserId());
        }

        eventProducer.fileEvent(event);


        return "redirect:/discuss/detail/" + discussPostId;
    }
}
