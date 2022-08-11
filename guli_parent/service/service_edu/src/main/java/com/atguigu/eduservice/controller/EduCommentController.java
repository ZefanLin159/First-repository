package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.JwtUtils;
import com.atguigu.commonutils.R;
import com.atguigu.commonutils.vo.MemberVo;
import com.atguigu.eduservice.client.MemberVoClient;
import com.atguigu.eduservice.entity.EduComment;
import com.atguigu.eduservice.service.EduCommentService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-08-06
 */
@RestController
@RequestMapping("/eduService/comment")
//@CrossOrigin
public class EduCommentController {
    @Autowired
    private EduCommentService commentService;
    @Autowired
    private MemberVoClient memberVoClient;

    @GetMapping("getComment/{page}/{limit}")
    public R getComment(@PathVariable long page, @PathVariable long limit, String courseId) {
        Page<EduComment> commentPage = new Page<>(page, limit);
        commentService.page(commentPage, null);
        QueryWrapper<EduComment> commentWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(courseId)) {
            commentWrapper.eq("course_id", courseId);
        }
        commentWrapper.orderByDesc("gmt_create");
        commentService.page(commentPage, commentWrapper);
        List<EduComment> records = commentPage.getRecords();
        long total = commentPage.getTotal();
        long current = commentPage.getCurrent();
        long pages = commentPage.getPages();
        long size = commentPage.getSize();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("records", records);
        map.put("total", total);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);

        return R.ok().data(map);
    }

    @PostMapping("auth/addComment")
    public R addComment(HttpServletRequest request, @RequestBody EduComment comment) {
        String memberId = JwtUtils.getMemberIdByJwtToken(request);
        if (StringUtils.isEmpty(memberId)) {
            return R.error().code(28004).message("请登录");
        }
        if (StringUtils.isEmpty(comment.getContent())) {
            throw new GuliException(20001, "评论不能为空");
        }
        comment.setMemberId(memberId);
        MemberVo memberVo = memberVoClient.getMemberInfoById(memberId);
        if (memberVo != null) {
            comment.setNickname(memberVo.getNickname());
            comment.setAvatar(memberVo.getAvatar());
            commentService.save(comment);
        } else
            throw new GuliException(20001, "memberVo不应该为空");
        return R.ok();

    }


}

