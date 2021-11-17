package com.HexTechGDUT.security;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.annotation.Inherited;

/**
 * 用户权限等级
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserAuth implements IEnum<String> {

    /**
     * 管理员
     */
    ADMIN(1, "ADMIN"),

    /**
     * 普通用户
     */
    ORDINARY(2, "ORDINARY"),

    /**
     * 恶意用户
     * 被举报次数过多
     * 多次发送无效申请
     * 多次发布违规评论
     * 等等...
     */
    FORBID(3, "FORBID");

    /**
     * 等级
     * 等级越小权限越大
     * 最大为1(管理员)
     */
    private int rank;

    /**
     * 权限等级的字符串
     * 用于在数据库中用户的表中存储
     */
    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
