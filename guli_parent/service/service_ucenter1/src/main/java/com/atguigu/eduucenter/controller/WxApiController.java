package com.atguigu.eduucenter.controller;

import com.atguigu.commonutils.JwtUtils;
import com.atguigu.eduucenter.entity.UcenterMember;
import com.atguigu.eduucenter.service.UcenterMemberService;
import com.atguigu.eduucenter.utils.ConstantWxUtils;
import com.atguigu.eduucenter.utils.HttpClientUtils;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

//@CrossOrigin
//@RestController // @Controller+@ResponseBody
@Controller
@RequestMapping("/api/ucenter/wx")
public class WxApiController {
    @Autowired
    private UcenterMemberService ucenterMemberService;

    @GetMapping("callback")
    public String callback(String code, String state) {
        try {
            String baseUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                    "appid=%s" + "&secret=%s" + "&code=%s" + "&grant_type=authorization_code";
            String accessTokenUrl = String.format(baseUrl, ConstantWxUtils.WX_OPEN_APP_ID, ConstantWxUtils.WX_OPEN_APP_SECRET, code);
//        使用httpclient模拟网页发送请求
            String accessTokenInfo = HttpClientUtils.get(accessTokenUrl);
            System.out.println("accessTokenInfo：" + accessTokenInfo);
//            需要 accessToken open_id 两个值 ，把字符串转成map
            Gson gson = new Gson();
            HashMap mapAccessToken = gson.fromJson(accessTokenInfo, HashMap.class);
            String access_token = (String) mapAccessToken.get("access_token");
            String openId = (String) mapAccessToken.get("openid");

//            把扫描人信息添加到数据库里面
//            判断数据表里面是否存在相同的微信信息，根据openid判断
            UcenterMember member = ucenterMemberService.getOpenIdMember(openId);
            if (member == null) {


                String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?" + "access_token=%s" + "&openid=%s";
                String userInfoUrl = String.format(baseUserInfoUrl, access_token, openId);
                String userInfo = HttpClientUtils.get(userInfoUrl);
                System.out.println("userInfo:" + userInfo);
                HashMap userInfoMap = gson.fromJson(userInfo, HashMap.class);
                String nickname = (String) userInfoMap.get("nickname");
                String headimgurl = (String) userInfoMap.get("headimgurl");

                member = new UcenterMember();
                member.setOpenid(openId);
                member.setNickname(nickname);
                member.setAvatar(headimgurl);
                ucenterMemberService.save(member);
            }
//            生成token是因为cookie不能跨域，这里是有重定向操作的
//            使用jwt，根据member对象生成token字符串
            String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
//            最后：返回首页面，通过路径传递token传递字符串
            return "redirect:http://localhost:3000?token=" + jwtToken;
        } catch (Exception e) {
            e.printStackTrace();

            throw new GuliException(20001, "微信登录失败");
        }

    }


    //    1.生成微信扫描二维码
    @GetMapping("login")
    public String getWxCode() {
////        固定地址，后面拼接参数(不推荐）
//        String url = "https://open.weixin.qq.com/connect/qrconnect?appid" +
//                ConstantWxUtils.WX_OPEN_APP_ID + "&redirect_uri" + ConstantWxUtils.WX_OPEN_REDIRECT_URL + "&response_type=code";

        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

//        对redirect_uri请使用 urlEncode 对链接进行处理
        String REDIRECT_URL = null;
        try {
            REDIRECT_URL = URLEncoder.encode(ConstantWxUtils.WX_OPEN_REDIRECT_URL, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String url = String.format(baseUrl, ConstantWxUtils.WX_OPEN_APP_ID, REDIRECT_URL, "atguigu");


//        1.重定向到请求请求微信地址里面
        return "redirect:" + url;
    }


}
