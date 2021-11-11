package com.HexTechGDUT.po.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 大致方位
 * @author HexTechGDUT
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Zone {

    /**
     * 东区
     */
    EAST("1"),

    /**
     * 西区
     */
    WEST("2")

    /**
     * 剩下区域待定
     */
    ;

    /**
     * 每个Zone都有一个id
     */
    private String zoneId;
}
