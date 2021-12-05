package com.HexTechGDUT.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HexTechGDUT
 */
@Data
public class AnimalQuery {

    @ApiModelProperty(value = "动物昵称，模糊查询")
    @TableField("animal_nickname")
    private String animalNickname;

    @ApiModelProperty(value = "最后出现的地址")
    @TableField("last_address")
    private String lastAddress;

    @ApiModelProperty(value = "动物种类")
    @TableField("animal_type")
    private String animalType;

    @ApiModelProperty(value = "目前状态" +
            "流浪动物：0:未被领养；1已被领养" +
            "寻找丢失动物：0:未找到，1已找到" +
            "弃养：0:未被领养，1已被领养，2放弃弃养")
    @TableField("status")
    private int status;

    @ApiModelProperty(value = "记录类型")
    @TableField("record_type")
    private int recordType;
}
