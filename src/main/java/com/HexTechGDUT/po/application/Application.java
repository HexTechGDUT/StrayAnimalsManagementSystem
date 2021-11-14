package com.HexTechGDUT.po.application;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 申请信息（申请领养或弃养）
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Application")
@TableName("application")
@ApiModel(value = "申请", description = "用户提交的申请,由管理员进行回复")
public class Application {

    /**
     * 申请id
     */
    @TableId("apply_id")
    @Size(max = 16)
    @ApiModelProperty(value = "申请id", notes = "每个申请独一无二的id")
    private String applyId;

    /**
     * 申请用户id
     */
    @TableField("uid")
    @ApiModelProperty(value = "用户id", notes = "申请的提交者id")
    private String uid;

    /**
     * 相关动物id
     */
    @TableField("animal_id")
    @ApiModelProperty(value = "动物id", notes = "该申请相关的动物id")
    private String animalId;

    /**
     * 申请类型
     */
    @TableField("type")
    @EnumValue
    @ApiModelProperty(value = "申请类型", notes = "申请类型,包括领养/弃养/申请走失等")
    private ApplicationType type;

    /**
     * 简要描述
     */
    @Size(max = 50)
    @TableField("brief_info")
    @ApiModelProperty(value = "申请的简要信息", notes = "申请的简单介绍和理由")
    private String briefInfo;

    /**
     * 申请时间
     */
    @TableField("apply_time")
    @ApiModelProperty(value = "申请时间", notes = "申请提交的时间")
    private LocalDateTime applyTime;

    /**
     * 申请状态
     */
    @TableField("status")
    @EnumValue
    @ApiModelProperty(value = "申请的状态", notes = "申请的状态等待处理/处理中/已处理等")
    private ApplicationStatus status;

    /**
     * 该属性只用于数据库连接查询处理结果时返回
     */
    private Answer answer;

}
