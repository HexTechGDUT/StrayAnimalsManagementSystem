package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;
import com.HexTechGDUT.po.address.Location;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 动物
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Animal")
@TableName("animal")
public class Animal {

    /**
     * 动物的id
     */
    @TableId("animal_id")
    @Size(max = 16)
    private String animalId;

    /**
     * 名字
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     * 限制年龄最大100岁
     * 总不能养的是祖传乌龟吧？
     */
    @Max(value = 100)
    @TableField("age")
    private int age;

    /**
     * 外貌
     * 最多50字
     */
    @Size(max = 50)
    @TableField("appearance")
    private String appearance;

    /**
     * 介绍
     * 最多50字
     */
    @Size(max = 50)
    @TableField("introduction")
    private String introduction;

    /**
     * 目前状态
     */
    @TableField("animal_status")
    @EnumValue
    private AnimalStatus animalStatus;

    /**
     * 动物的健康状态
     */
    @TableField("isHealthy")
    private boolean isHealthy;

    /**
     * 动物的图片
     * 该属性只用于数据库查询
     */
    @TableField(exist = false)
    private List<AnimalPicture> pictureList;

    /**
     * 位置
     * 该属性只用于数据库查询
     */
    @TableField(exist = false)
    private Location location;

    /**
     * 上传者id
     */
    @TableField("uid")
    private String uid;

    /**
     * 信息最后更新时间
     */
    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;

}
