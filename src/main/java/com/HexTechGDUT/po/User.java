package com.HexTechGDUT.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

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
     * User表的id
     */
    @TableId("id")
    private int id;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",notes = "区别每个用户的字符串")
    @TableField("user_id")
    @Size(max = 16)
    private String userId;

    /**
     * 名字
     * 初始默认设置为user
     * 待定
     */
    @ApiModelProperty(value = "用户名", notes = "由用户随意填写的名称")
    @TableField("user_name")
    @Size(max = 12)
    private String userName;

    /**
     * 电话号
     */
    @ApiModelProperty(value = "电话号", notes = "长度固定为11位")
    @TableField("phone_number")
    @Size(min = 11, max = 11)
    private String phoneNumber;

    /**
     * 密码
     * 长度为8-16位
     */
    @ApiModelProperty(value = "密码", notes = "用户登录时使用")
    @TableField("password")
    @Size(min = 8, max = 16)
    private String password;

    /**
     * 用户权限
     */
    @ApiModelProperty(value = "权限", notes = "用于判断登录用户的操作权限")
    @TableField("user_type")
    private int userType;

    /**
     * 位置
     */
    @ApiModelProperty(value = "位置", notes = "该字符串最多50字")
    @TableField("contact_address")
    @Size(max = 50)
    private String contactAddress;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "注册时间", notes = "用户创建该用户的时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", notes = "用户修改信息的时间")
    @TableField("update_time")
    private LocalDateTime updateTime;
}
