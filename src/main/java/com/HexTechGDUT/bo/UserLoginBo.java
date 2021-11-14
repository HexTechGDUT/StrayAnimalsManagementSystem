package com.HexTechGDUT.bo;

import com.HexTechGDUT.po.user.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 用户登录凭证
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用户登录凭证", description = "包括用户和token")
public class UserLoginBo {

    /**
     * 用户
     */
    @ApiModelProperty(value = "登录用户")
    private User user;

    /**
     * 登录token
     */
    @ApiModelProperty(value = "登录token")
    private String loginToken;

    /**
     * 待添加其他属性
     */
}
