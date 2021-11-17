package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 动物
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("AnimalRecord")
@TableName("animal_record")
public class AnimalRecord {

    /**
     * 动物记录id
     */
    @TableId("id")
    private int id;

    /**
     * 上传者id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 该动物更早的记录id
     */
    @TableField("previous_record_id")
    private int previousRecordId;

    /**
     * 该动物出现的时间
     * 若为弃养动物则为null
     */
    @TableField("found_date")
    private LocalDateTime foundDate;

    /**
     * 该动物最后出现的位置
     * 若为弃养动物则为null
     */
    @TableField("last_address")
    @Size(max = 50)
    private String lastAddress;

    /**
     * 动物的品种
     */
    @TableField("animal_type")
    @Size(max = 10)
    private String animalType;

    /**
     * 额外信息
     */
    @TableField("additional_information")
    private String additionalInformation;

    /**
     * 目前状态
     * 流浪动物：0:未被领养；1已被领养
     * 寻找丢失动物：0:未找到，1已找到
     * 弃养：0:未被领养，1已被领养，2放弃弃养
     */
    @TableField("status")
    private int status;

    /**
     * 记录的类型
     * 为流浪动物，还是弃养动物，还是寻找失去的宠物
     */
    @TableField("record_type")
    @Size(max = 10)
    private String recordType;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

}
