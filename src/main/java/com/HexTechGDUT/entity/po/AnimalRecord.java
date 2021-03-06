package com.HexTechGDUT.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 动物
 * @author HexTechGDUT
 */
@Data
@ApiModel("动物")
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("AnimalRecord")
@TableName("animal_record")
public class AnimalRecord {

    /**
     * 动物记录id
     */
    @ApiModelProperty("动物id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    /**
     * 动物昵称
     */
    @ApiModelProperty("动物昵称")   
    @TableField("animal_nickname")
    private String animalNickname;

    /**
     * 该动物出现的时间
     * 若为弃养动物则为null
     */
    @ApiModelProperty("该动物出现的时间")
    @TableField("found_date")
    private LocalDateTime foundDate;

    /**
     * 该动物最后出现的位置
     * 若为弃养动物则为null
     */
    @ApiModelProperty("该动物最后出现的位置")
    @TableField("last_address")
    @Size(max = 50)
    private String lastAddress;

    /**
     * 最后出现位置的索引
     */
    @ApiModelProperty("该动物最后出现的位置的一级索引，方便前端处理")
    @TableField("address_first_index")
    private int addressFirstIndex;

    @ApiModelProperty("该动物最后出现的位置的二级索引，方便前端处理")
    @TableField("address_second_index")
    private int addressSecondIndex;

    /**
     * 动物的品种
     */
    @ApiModelProperty("动物的品种")
    @TableField("animal_type")
    @Size(max = 10)
    private String animalType;

    /**
     * 动物品种的索引
     */
    @ApiModelProperty("动物品种的索引，方便前端处理")
    @TableField("animal_type_index")
    private String animalTypeIndex;

    /**
     * 额外信息
     */
    @ApiModelProperty("额外信息")
    @TableField("additional_information")
    private String additionalInformation;

    /**
     * 目前状态
     * 流浪动物：0:未被领养；1已被领养
     * 寻找丢失动物：0:未找到，1已找到
     * 弃养：0:未被领养，1已被领养，2放弃弃养
     */
    @ApiModelProperty("目前状态")
    @TableField("status")
    private int status;

    /**
     * 动物的健康状况
     */
    @ApiModelProperty("健康状况")
    @TableField("health")
    private String health;

    /**
     * 健康状况的索引
     */
    @ApiModelProperty("健康状况的索引，方便前端处理")
    @TableField("health_index")
    private String healthIndex;

    /**
     * 记录的类型
     * 为流浪动物，还是弃养动物，还是寻找失去的宠物
     */
    @ApiModelProperty("记录的类型")
    @TableField("record_type")
    @Size(max = 10)
    private int recordType;

    /**
     * 最后出现时间，在字符串规范化后通过String存储
     */
    @ApiModelProperty("最后发现时间")
    @TableField("last_found_time")
    private String lastFoundTime;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 一个动物可能对应多张图片，用ArrayList存储
     */
    @TableField(exist = false)
    private List<AnimalImg> animalImgList = new ArrayList<>();
}
