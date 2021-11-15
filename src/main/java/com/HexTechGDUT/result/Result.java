package com.HexTechGDUT.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 返回给前端的结果对象
 * Controller中返回json
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {

    /**
     * 结果类型
     * resultType.***.getCode()
     */
    private int resultTypeCode;

    /**
     * 结果信息
     */
    private String resultInfo;

    /**
     * 结果附带的对象
     */
    private T data;
}
