package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录时传帐号和密码
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用户登录Bo", description = "包括用户id,密码")
public class LoginBo {

    /**
     * 登录帐号
     */
    @ApiModelProperty(value = "登录id")
    @NotBlank(message = "帐号不能为空")
    private String userId;

    /**
     * 登录密码
     */
    @ApiModelProperty(value = "登录密码")
    @NotBlank(message = "密码不能为空")
    private String pwd;
}
