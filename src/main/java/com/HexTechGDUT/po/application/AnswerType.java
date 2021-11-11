package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 申请的处理结果的类型
 * 允许/驳回
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum AnswerType {

    /**
     * 驳回申请
     */
    REJECT(0, "reject"),

    /**
     * 允许申请
     */
    PERMIT(1, "permit");

    private int code;

    private String typeStr;

}
