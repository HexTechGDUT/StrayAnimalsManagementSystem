package com.HexTechGDUT.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
@ApiModel(value = "申请", description = "用户提交的申请,由管理员进行回复")
public class Application {

    /**
     *  申请id
     */
    @TableId("id")
    private int id;

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
    private String animalRecordId;

    /**
     * 申请的具体信息
     */
    @TableField("information")
    private String information;

    /**
     * 申请类型
     */
    @TableField("type")
    @ApiModelProperty(value = "申请类型", notes = "申请类型,包括领养/弃养/申请走失等")
    private int type;

    /**
     * 申请状态
     */
    @TableField("status")
    @ApiModelProperty(value = "申请的状态", notes = "申请的状态等待处理/处理中/已处理等")
    private int status;

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
