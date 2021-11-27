package com.HexTechGDUT.entity.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    @TableId("id")
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
     * 返回给前端时切分后的地址数组
     */
    @TableField(exist = false)
    private String[] returnAddress;

    /**
     * 动物的品种
     */
    @ApiModelProperty("动物的品种")
    @TableField("animal_type")
    @Size(max = 10)
    private String animalType;

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
     * 记录的类型
     * 为流浪动物，还是弃养动物，还是寻找失去的宠物
     */
    @ApiModelProperty("记录的类型")
    @TableField("record_type")
    @Size(max = 10)
    private int recordType;

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
