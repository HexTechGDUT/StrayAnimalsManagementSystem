package com.HexTechGDUT.po.user;

import com.HexTechGDUT.security.UserAuth;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;
import com.HexTechGDUT.po.address.Location;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

/**
 * 用户
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("User")
@TableName("User")
public class User {

    /**
     * 用户id
     */
    @TableId("uid")
    private String uid;

    /**
     * 名字
     * 初始默认设置为手机号或者uid
     * 待定
     */
    @TableField("name")
    @Max(value = 12)
    private String name;

    /**
     * 密码
     * 长度为8-16位
     */
    @TableField("pwd")
    @Max(value = 16)
    @Min(value = 8)
    private String pwd;

    /**
     * 电话号
     */
    @TableField("phone")
    @Max(value = 11)
    @Min(value = 11)
    private String phone;

    /**
     * 邮箱
     * 该属性只是为了注册时好看放在这里，其实业务上是不会用的
     * VARCHAR(254)
     */
    @TableField("email")
    @Email
    private String email;

    /**
     * 位置
     * 查询用户时，通过uid连接查询Location表
     */
    private Location location;

    /**
     * 用户权限
     */
    @EnumValue
    @TableField("auth")
    private UserAuth auth;

    /**
     * 最后更新时间
     */
    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;
}
