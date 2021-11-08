package com.HexTechGDUT.po.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import com.HexTechGDUT.po.common.Location;

/**
 * 用户
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {

    /**
     * 用户id
     */
    private String uid;

    /**
     * 名字
     * 初始默认设置为手机号或者uid
     * 待定
     */
    private String name;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 电话号
     */
    private String phoneNumber;

    /**
     * 邮箱
     */
    @Nullable
    private String email;

    /**
     * 位置
     */
    private Location location;

    /**
     * 用户权限
     */
    private UserAuth auth;
}
