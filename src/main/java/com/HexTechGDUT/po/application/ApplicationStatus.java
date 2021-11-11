package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 申请的状态
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApplicationStatus {

    /**
     * 等待处理
     */
    WAIT(0, "等待处理"),

    /**
     * 处理中
     */
    PROCESSING(1, "处理中"),

    /**
     * 处理完成
     */
    PROCESSED(2, "处理完成"),

    /**
     * 取消申请
     */
    CANCEL(-1, "取消申请");

    /**
     * 状态代码
     */
    private int code;

    private String statusInfo;
}
