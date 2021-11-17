package com.HexTechGDUT.po.user;

import com.HexTechGDUT.po.address.Location;
import com.HexTechGDUT.security.UserAuth;
import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.type.Alias;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 用户
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("User")
@TableName(value = "user")
@ApiModel(value = "用户", description = "用户")
public class User {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",notes = "区别每个用户的字符串")
    @TableId("uid")
    private String uid;

    /**
     * 名字
     * 初始默认设置为手机号或者uid
     * 待定
     */
    @ApiModelProperty(value = "用户名", notes = "由用户随意填写的名称", position = 1)
    @TableField("name")
    @Size(max = 12)
    private String name;

    /**
     * 密码
     * 长度为8-16位
     */
    @ApiModelProperty(value = "密码", notes = "用户登录时使用", position = 2)
    @TableField("pwd")
    @Size(min = 8, max = 16)
    private String pwd;

    /**
     * 电话号
     */
    @ApiModelProperty(value = "电话号", notes = "长度固定为11位", position = 3)
    @TableField("phone")
    @Size(min = 11, max = 11)
    private String phone;

    /**
     * 邮箱
     * 该属性只是为了注册时好看放在这里，其实业务上是不会用的
     * VARCHAR(254)
     */
    @ApiModelProperty(value = "邮箱", notes = "目前该属性只是为了好看,无任何业务上的意义", position = 4)
    @TableField("email")
    @Email
    private String email;

    /**
     * 位置
     * 查询用户时，通过uid连接查询Location表
     */
    @TableField(exist = false)
    private Location location;

    /**
     * 用户权限
     */
    @ApiModelProperty(value = "权限", notes = "用于判断登录用户的操作权限", position = 5)
    @EnumValue
    @TableField("auth")
    private UserAuth auth;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间", notes = "用户最后一次修改信息的时间", position = 6)
    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;
}
