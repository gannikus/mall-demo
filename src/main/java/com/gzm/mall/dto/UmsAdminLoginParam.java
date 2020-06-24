package com.gzm.mall.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


/**
 * 用户登录参数
 *
 * @author gzm
 * @date 2018/4/26
 */
@Getter
@Setter
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

}
