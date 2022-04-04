```java
//        查询评论的分页信息
        page.setLimit(5);
        page.setPath("discuss/detail/" + discussPostId);
        page.setRows(discussPost.getCommentCount());


//        套娃（断点看一下）
//        评论：给帖子的评论
//        回复：给评论的评论
//        评论列表
        List<Comment> commentList = commentService.findCommentByEntity(ENTITY_TYPE_POST, discussPost.getId(),
                page.getOffset(), page.getLimit());
//评论View object列表
        List<Map<String, Object>> commentVoList = new ArrayList<>();
        if (commentList != null) {
            for (Comment comment : commentList) {
//                单个评论的VO
                Map<String, Object> commentVo = new HashMap<>();
                //评论
                commentVo.put("comment", comment);
                //作者
                commentVo.put("user", userService.findById(comment.getUserId()));
                //回复列表(不分页）
                List<Comment> replyList = commentService.findCommentByEntity(ENTYTY_TYPE_COMMENT,
                        comment.getId(), 0, Integer.MAX_VALUE);
                //回复的VO列表
                List<Map<String, Object>> replyVoList = new ArrayList<>();
                if (replyList != null) {
                    for (Comment reply : replyList) {
                        Map<String, Object> replyVo = new HashMap<>();
//                        回复
                        replyVo.put("reply", reply);
//                        作者
                        replyVo.put("user", userService.findById(reply.getUserId()));
//                        回复目标
                        User target = reply.getTargetId() == 0 ? null : userService.findById(reply.getTargetId());
                        replyVo.put("target", target);
                        replyVoList.add(replyVo);
                    }
                }
                commentVo.put("replys", replyVoList);
//                回复数量
                int replyCount = commentService.findCommentCount(ENTYTY_TYPE_COMMENT, comment.getId());
                commentVo.put("replyCount", replyCount);
                commentVoList.add(commentVo);
            }
        }
        model.addAttribute("comments", commentVoList);
        return "site/discuss-detail";
```