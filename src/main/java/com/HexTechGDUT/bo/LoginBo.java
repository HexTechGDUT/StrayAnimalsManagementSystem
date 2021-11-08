package com.HexTechGDUT.bo;

import lombok.*;

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
    private String uid;

    /**
     * 登录密码
     */
    private String pwd;
}
