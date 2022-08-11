package com.atguigu.vod.controller;

import com.atguigu.commonutils.R;
import com.atguigu.vod.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/eduvod/video")
//@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    @PostMapping("uploadVideoAli")
    public R uploadVideoAli(MultipartFile file) {
        String videoId = vodService.uploadVideo(file);
        return R.ok().data("videoId", videoId);
    }

    @DeleteMapping("deleteVideoAli/{videoId}")
    public R deleteVideoAli(@PathVariable String videoId) {
        vodService.removeVideoById(videoId);
        return R.ok();
    }

    @DeleteMapping("deleteList")
    public R deleteVideoAliList(@RequestParam("videoList") List<String> videoList) {
        vodService.deleteVideoList(videoList);
        return R.ok();
    }

    @GetMapping("getVideoTicket/{videoSourceId}")
    public R getVideoTicket(@PathVariable String videoSourceId) {
//        System.out.println(videoSourceId);
        String playAuth = vodService.getTicket(videoSourceId);
        return R.ok().data("playAuth", playAuth);
    }
}
