package com.HexTechGDUT.po.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 用户权限
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum UserAuth {

    /**
     * 管理员
     */
    ADMIN(1),

    /**
     * 普通用户
     */
    ORDINARY(2),

    /**
     * 恶意用户
     * 被举报次数过多
     * 多次发送无效申请
     * 等等...
     */
    FORBID(3);

    /**
     * 等级
     * 等级越小权限越大
     * 最大为1
     */
    private int rank;
}
