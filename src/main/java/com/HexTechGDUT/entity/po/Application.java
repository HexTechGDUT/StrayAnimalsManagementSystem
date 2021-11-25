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
    @TableId("id")
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
    @ApiModelProperty("申请的具体信息")
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
    @ApiModelProperty(value = "申请类型", notes = "申请类型,包括领养/弃养/申请走失等")
    private int type;

    /**
     * 申请状态
     * 0:等待处理,1:申请被通过,2:申请被驳回,3:被申请用户撤销
     */
    @TableField("status")
    @ApiModelProperty(value = "申请的状态", notes = "申请的状态等待处理/处理中/已处理等")
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
