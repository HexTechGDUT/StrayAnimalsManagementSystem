package com.HexTechGDUT.po.address;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 位置所属的区域
 * 东区/西区/...
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Zone implements IEnum<String> {

    /**
     * 东区
     */
    EAST("1", "EAST"),

    /**
     * 西区
     */
    WEST("2", "WEST")

    /**
     * 剩下区域待定
     */
    ;

    /**
     * 每个Zone都有一个id
     */
    private String zoneId;

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
