package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 处理结果的类型
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultType {

    /**
     * 驳回申请
     */
    REJECT,

    /**
     * 允许申请
     */
    PERMIT

}
