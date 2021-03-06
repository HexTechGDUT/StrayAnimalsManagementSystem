package com.HexTechGDUT.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 申请信息（申请领养或弃养）
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Application")
@TableName("application")
@ApiModel(value = "申请", description = "用户提交的申请")
public class Application {

    /**
     *  申请id
     */
    @TableId(value = "id",type = IdType.AUTO)
    @ApiModelProperty("申请id")
    private Integer id;

    /**
     * 申请用户id
     */
    @TableField("user_id")
    @ApiModelProperty(value = "用户id", notes = "申请的提交者id")
    private String userId;

    /**
     * 相关动物id
     */
    @TableField("animal_record_id")
    @ApiModelProperty(value = "动物id", notes = "该申请相关的动物id")
    private int animalRecordId;

    /**
     * 申请的具体信息
     */
    @TableField("information")
    @ApiModelProperty(value = "申请的具体信息",notes = "动物信息相关的JSON")
    private String information;

    /**
     * 申请类型
     * 10:发布新的流浪动物信息
     * 11:追加新的流浪动物信息
     * 12:申请领养流浪动物
     * 20:发布新的弃养动物信息
     * 21:申请领养弃养动物
     * 30:发布新的走失动物信息
     * 31:追加走失动物信息
     */
    @TableField("type")
    @ApiModelProperty(value = "申请类型", notes = "申请类型,1、发布动物信息/2、修改动物信息")
    private int type;

    /**
     * 申请状态
     * 1:等待处理,2:申请被通过,3:申请被驳回,4:被申请用户撤销
     */
    @TableField("status")
    @ApiModelProperty(value = "申请的状态", notes = "1、等待处理/2、通过申请/3、不通过申请/4、用户取消申请")
    private int status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
