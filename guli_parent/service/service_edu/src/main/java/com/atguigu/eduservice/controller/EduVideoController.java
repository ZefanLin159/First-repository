package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testJava
 * @since 2022-07-22
 */
@RestController
@RequestMapping("/eduService/video")
//@CrossOrigin
public class EduVideoController {

    @Autowired
    private VodClient vodClient;
    @Autowired
    private EduVideoService videoService;

    //    添加小节
    @PostMapping("addVideo")
    public R addVideo(
            @RequestBody EduVideo eduVideo) {
        videoService.save(eduVideo);
        return R.ok();
    }


    //    修改当前回显章节
    @GetMapping("getVideo/{videoId}")
    public R getVideo(@PathVariable String videoId) {
        EduVideo eduVideo = videoService.getById(videoId);
        return R.ok().data("video", eduVideo);
    }

    //    修改小节 TODO
    @PostMapping("updateVideo/{videoId}")
    public R updateVideo(
            @PathVariable String videoId,
            @RequestBody EduVideo eduVideo) {
        eduVideo.setId(videoId);
        videoService.updateById(eduVideo);
        return R.ok();
    }

    //    删除小节
    // TODO 需要完善（删除小节同时删除阿里云视频）
    @DeleteMapping("deleteVideo/{videoId}")
    public R deleteVideo(
            @PathVariable String videoId) {
//        先删视频再删小节
//        通过nacos远程调用另一个模块的删除视频方法
        EduVideo eduVideo = videoService.getById(videoId);
        String videoSourceId = eduVideo.getVideoSourceId();
        if (!videoSourceId.isEmpty()) {
            R r = vodClient.deleteVideoAli(videoSourceId);
            if (r.getCode() == 20001) {
                throw new GuliException(20001, "删除视频失败，熔断器生效");
            }
        }
//        删除小节
        boolean result = videoService.removeChapterById(videoId);
        if (result) {
            return R.ok();
        } else {
            return R.error().message("删除失败");
        }
    }


}

