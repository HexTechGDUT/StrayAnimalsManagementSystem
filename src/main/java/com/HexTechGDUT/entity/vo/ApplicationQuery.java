package com.HexTechGDUT.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplicationQuery {
    @ApiModelProperty(value="申请类型,1、发布动物信息/2、修改动物信息")
    @TableField("type")
    private Integer type;

    @ApiModelProperty(value = "1、等待处理/2、通过申请/3、不通过申请/4、用户取消申请")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "该申请相关的动物id")
    @TableField("animalRecordId")
    private Integer animalRecordId;
}
