package com.atguigu.eduservice.client;

import com.atguigu.commonutils.R;
import com.atguigu.eduservice.client.impl.VodFileDegradeFeighClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(name = "server-vod", fallback = VodFileDegradeFeighClientImpl.class) //nacos中的名字
public interface VodClient {
    //    删除小节
    @DeleteMapping("/eduvod/video/deleteVideoAli/{videoId}")
    public R deleteVideoAli(@PathVariable("videoId") String videoId);

    @DeleteMapping("/eduvod/video/deleteList")
    public R deleteVideoAliList(@RequestParam("videoList") List<String> videoList);

}
