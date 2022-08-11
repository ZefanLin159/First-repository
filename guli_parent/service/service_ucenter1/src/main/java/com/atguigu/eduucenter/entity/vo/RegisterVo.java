package com.atguigu.eduucenter.entity.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RegisterVo {
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;


    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "手机验证码")
    private String verification;
}
