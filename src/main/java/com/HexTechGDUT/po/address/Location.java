package com.HexTechGDUT.po.address;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 位置信息
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Location")
@TableName(value = "location")
@ApiModel(value = "位置", description = "用户或动物的位置信息")
public class Location {

    @TableId("id")
    @Size(max = 16)
    @ApiModelProperty(value = "位置id", notes = "位置在数据库表中存储的id")
    private String id;

    /**
     * 该地址为用户地址
     * 每个用户都有唯一的Location
     */
    @TableField("uid")
    @ApiModelProperty(value = "用户id", notes = "若位置为用户位置，则该属性为用户id，否则为空")
    private String uid;

    /**
     * 该地址为动物出现地址
     * 则该地址为动物出现过的地址
     * 每个动物可有多条地址, 按时间排序后返回
     */
    @TableField("animal_id")
    @ApiModelProperty(value = "动物id", notes = "若位置为动物位置，则该属性为动物id，否则为空")
    private String animalId;

    /**
     * 大致方位
     * 如：东，西区
     */
    @EnumValue
    @TableField("zone")
    @ApiModelProperty(value = "区域Enum", notes = "位置的所在的区域")
    private Zone zone;

    /**
     * 具体位置
     * 由用户自己输入
     * 字符串长度不超过20
     */
    @TableField("spec_locate")
    @Size(max = 20)
    @ApiModelProperty(value = "具体的位置", notes = "由用户填写具体的位置")
    private String specLocate;

    /**
     * 更新时间
     */
    @TableField("update_time")
    @ApiModelProperty(value = "位置更新时间", notes = "记录该条位置信息上传的时间")
    private LocalDateTime updateTime;
}
