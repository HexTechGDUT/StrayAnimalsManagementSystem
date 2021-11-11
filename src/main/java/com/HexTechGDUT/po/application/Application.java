package com.HexTechGDUT.po.application;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
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
public class Application {

    /**
     * 申请id
     */
    @TableId("apply_id")
    private String applyId;

    /**
     * 申请类型
     */
    @TableField("type")
    @EnumValue
    private ApplicationType type;

    /**
     * 简要描述
     */
    @Max(value = 50)
    @TableField("brief_info")
    private String briefInfo;

    /**
     * 相关动物id
     */
    @TableField("animal_id")
    private String animalId;

    /**
     * 申请用户id
     */
    @TableField("uid")
    private String uid;

    /**
     * 申请时间
     */
    @TableField("apply_time")
    private LocalDateTime applyTime;

    /**
     * 申请状态
     */
    @TableField("status")
    @EnumValue
    private ApplicationStatus status;

    /**
     * 处理结果的id
     */
    @TableField(value = "answer_id")
    private String answerId;

    /**
     * 该属性只用于数据库连接查询处理结果时返回
     */
    private Answer answer;

}
