package com.atguigu.vod.service.impl;

import com.aliyun.tea.TeaException;
import com.aliyun.teautil.models.RuntimeOptions;
import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadFileStreamRequest;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.req.UploadURLStreamRequest;
import com.aliyun.vod.upload.req.UploadVideoRequest;
import com.aliyun.vod.upload.resp.UploadFileStreamResponse;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyun.vod.upload.resp.UploadURLStreamResponse;
import com.aliyun.vod.upload.resp.UploadVideoResponse;


import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.vod.model.v20170321.*;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.atguigu.vod.service.VodService;
import com.atguigu.vod.utils.ConstantVodUtils;
import com.atguigu.vod.utils.InitVod;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.io.InputStream;
import java.rmi.ServerException;
import java.util.List;

import static com.atguigu.vod.utils.InitVod.initVodClient;

@Service
public class VodServiceImpl implements VodService {

    //    流式上传
    public String uploadVideo(MultipartFile file) {
        /*accessKeyId，accessKeySecret
         * title：上传之后显示的名称
         * fileName：上传文件原始名称
         * inputStream 文件输入流*/
        String title = "";
        String fileName = file.getOriginalFilename();
        if (fileName != null) {
            title = fileName.substring(0, fileName.lastIndexOf("."));
        }
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        UploadStreamRequest request = new UploadStreamRequest(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET, title, fileName, inputStream);
        UploadVideoImpl uploader = new UploadVideoImpl();
        UploadStreamResponse response = uploader.uploadStream(request);
        if (response.isSuccess()) {
            System.out.print("VideoId=" + response.getVideoId() + "\n");
        } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            System.out.print("VideoId=" + response.getVideoId() + "\n");
            System.out.print("ErrorCode=" + response.getCode() + "\n");
            System.out.print("ErrorMessage=" + response.getMessage() + "\n");
        }
        return response.getVideoId();
    }

    @Override
    public void removeVideoById(String videoId) {
        DeleteVideoResponse response = new DeleteVideoResponse();
        try {
            DefaultAcsClient client = InitVod.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            //支持传入多个视频ID，多个用逗号分隔
            request.setVideoIds(videoId);
            client.getAcsResponse(request);
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
            throw new GuliException(20001, "删除视频失败");
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");

    }

    @Override
    public void deleteVideoList(List<String> videoList) {
        DeleteVideoResponse response = new DeleteVideoResponse();
        try {
            DefaultAcsClient client = InitVod.initVodClient(ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            //支持传入多个视频ID，多个用逗号分隔
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < videoList.size(); i++) {
                sb.append(videoList.get(i));
                if (i != videoList.size() - 1) {
                    sb.append(",");
                }
            }
            String testText = sb.toString();
            request.setVideoIds(sb.toString());
            client.getAcsResponse(request);
        } catch (Exception e) {
            System.out.print("ErrorMessage = " + e.getLocalizedMessage());
            throw new GuliException(20001, "删除视频失败");
        }
        System.out.print("RequestId = " + response.getRequestId() + "\n");
    }

    @Override
    public String getTicket(String videoSourceId) {
        DefaultProfile profile = DefaultProfile.getProfile(ConstantVodUtils.END_POINT, ConstantVodUtils.ACCESS_KEY_ID, ConstantVodUtils.ACCESS_KEY_SECRET);
        /** use STS Token
         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         "<your-access-key-id>",       // The AccessKey ID of the RAM account
         "<your-access-key-secret>",   // The AccessKey Secret of the RAM account
         "<your-sts-token>");          // STS Token
         **/

        IAcsClient client = new DefaultAcsClient(profile);

        GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
        request.setVideoId(videoSourceId);
        request.setAuthInfoTimeout(3000L);

        try {
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
//            System.out.println(new Gson().toJson(response));
//            System.out.println(new Gson().toJson(response.getVideoMeta()));
            return response.getPlayAuth();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
            return "";
        }

    }


}
