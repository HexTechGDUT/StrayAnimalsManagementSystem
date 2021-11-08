package com.HexTechGDUT.po.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import com.HexTechGDUT.po.common.Location;

import java.time.LocalDateTime;

/**
 * 动物
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Animal {

    /**
     * 动物的id
     */
    private String animalId;

    /**
     * 名字
     */
    private String name;

    /**
     * 生日
     * @deprecated
     */
    private LocalDateTime birthday;

    /**
     * 年龄
     */
    private int age;

    /**
     * 外貌
     */
    private String appearance;

    /**
     * 介绍
     */
    private String introduction;

    /**
     * 目前状态
     */
    private AnimalStatus status;

    /**
     * 位置
     */
    private Location location;

    /**
     * 信息最后更新时间
     */
    private LocalDateTime lastUpdateTime;

}
