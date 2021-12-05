package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 登录成功时返回给前端的信息
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel("用户登录成功时返回给前端的信息")
public class UserLoginBo {

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;

    /**
     * 用户身份
     */
    @ApiModelProperty("用户身份")
    private Integer userType;

    /**
     * 头像路径
     */
    @ApiModelProperty("头像路径")
    private String avatar;

    /**
     * token
     */
    @ApiModelProperty("token")
    private String token;
}
