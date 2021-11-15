package com.HexTechGDUT.po.application;

import com.baomidou.mybatisplus.annotation.IEnum;
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
public enum AnswerType implements IEnum<String> {

    /**
     * 驳回申请
     */
    REJECT(0, "REJECT"),

    /**
     * 允许申请
     */
    PERMIT(1, "PERMIT");

    private int code;

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
