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

import java.time.LocalDateTime;

/**
 * 申请的处理结果
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("Answer")
@TableName("answer")
public class Answer {

    /**
     * 处理id
     */
    @TableId("answer_id")
    private String answerId;

    /**
     * 处理结果
     */
    @EnumValue
    @TableField("answer_type")
    private AnswerType answerType;

    /**
     * 具体处理结果和原因
     */
    @TableField("details")
    private String details;

    /**
     * 处理人id
     * 一般为管理员
     */
    @TableField("uid")
    private String uid;

    /**
     * 处理时间
     */
    @TableField("answer_time")
    private LocalDateTime answerTime;
}
