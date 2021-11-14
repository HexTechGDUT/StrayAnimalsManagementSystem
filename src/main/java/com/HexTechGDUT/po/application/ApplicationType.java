package com.HexTechGDUT.po.application;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 申请的类型
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApplicationType implements IEnum<String> {

    /**
     * 领养
     * 领养流浪动物
     */
    ADOPT("ADOPT"),

    /**
     * 弃养
     * 学生毕业或者老师离职
     * 若无法将动物带离校园，可以选择弃养
     */
    ABANDON("ABANDON"),

    /**
     * 申请动物走失的登记
     */
    LOST("LOST"),

    /**
     * 回收
     * 将流浪动物带回一个指定地方等待处理
     */
    RECALL("RECALL");

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
