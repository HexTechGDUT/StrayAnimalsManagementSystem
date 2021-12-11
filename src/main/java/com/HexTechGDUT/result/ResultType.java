package com.HexTechGDUT.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 返回给前端的结果的类型
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultType {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(400, "操作失败"),

    /**
     * 没有权限操作
     */
    NO_PERMIT(403, "没有权限操作");

    /**
     * 结果类型代码
     */
    private int code;

    /**
     * 默认信息
     */
    private String info;

}
