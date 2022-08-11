package com.atguigu.vod.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VodService {
    String uploadVideo(MultipartFile file);

    void removeVideoById(String videoId);

    void deleteVideoList(List<String>  videoList);

    String getTicket(String videoSourceId);
}
