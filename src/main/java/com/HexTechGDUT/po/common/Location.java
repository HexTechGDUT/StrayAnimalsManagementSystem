package com.HexTechGDUT.po.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * 位置信息
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Location {

    /**
     * 大致方位
     * 如：东，西区
     */
    private Zone zone;

    /**
     * 具体位置
     */
    private String specificLocate;
}
