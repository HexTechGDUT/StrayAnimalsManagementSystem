package com.HexTechGDUT.bo;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * 用户登录时传帐号和密码
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginBo {

    /**
     * 登录帐号
     */
    @NotBlank(message = "帐号不能为空")
    private String uid;

    /**
     * 登录密码
     */
    @NotBlank(message = "密码不能为空")
    private String pwd;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;
}
