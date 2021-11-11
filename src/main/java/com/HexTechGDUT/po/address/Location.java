package com.HexTechGDUT.po.address;

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

import javax.validation.constraints.Max;
import java.time.LocalDateTime;

/**
 * 位置信息
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Location")
@TableName("location")
public class Location {

    @TableId("id")
    private String id;

    /**
     * 该地址为用户地址
     * 每个用户都有唯一的Location
     */
    @TableField("uid")
    private String uid;

    /**
     * 该地址为动物出现地址
     * 则该地址为动物出现过的地址
     * 每个动物可有多条地址, 按时间排序后返回
     */
    @TableField("animal_id")
    private String animalId;

    /**
     * 大致方位
     * 如：东，西区
     */
    @EnumValue
    @TableField("zone")
    private Zone zone;

    /**
     * 具体位置
     * 由用户自己输入
     * 字符串长度不超过20
     */
    @TableField("spec_locate")
    @Max(value = 20)
    private String specificLocate;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}
