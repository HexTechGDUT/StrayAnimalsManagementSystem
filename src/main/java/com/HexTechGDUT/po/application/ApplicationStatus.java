package com.HexTechGDUT.po.application;

import com.baomidou.mybatisplus.annotation.IEnum;
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
public enum ApplicationStatus implements IEnum<String> {

    /**
     * 等待处理
     */
    WAIT(0, "WAIT", "等待处理"),

    /**
     * 处理中
     */
    PROCESS(1, "PROCESS", "处理中"),

    /**
     * 处理完成
     */
    FINISHED(2,"FINISHED", "处理完成"),

    /**
     * 取消申请
     */
    CANCEL(-1,"CANCEL", "取消申请");

    /**
     * 状态代码
     */
    private int code;

    private String value;

    private String statusInfo;

    @Override
    public String getValue() {
        return value;
    }
}
