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

import java.time.LocalDateTime;
import java.util.List;

/**
 * 对动物的评论
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("评论")
@Alias("Comment")
@TableName("comment")
public class Comment {

    /**
     * 评论id
     */
    @ApiModelProperty("评论id")
    @TableId("id")
    private Integer id;

    /**
     * 评论所属的动物id
     */
    @ApiModelProperty("评论所属的动物id")
    @TableField("animal_record_id")
    private String animalRecordId;

    /**
     * 发布评论的用户id
     */
    @ApiModelProperty("发布评论的用户id")
    @TableField("user_id")
    private String userId;

    /**
     * 评论的具体内容
     */
    @ApiModelProperty("评论的具体内容")
    @TableField("content")
    private String content;

    /**
     * 若该评论为另一条评论的子评论
     * 该属性记录该评论的父评论
     */
    @ApiModelProperty("若该评论为另一条评论的子评论,该属性记录该评论的父评论")
    @TableField("previous_comment_id")
    private String previousCommentId;

    /**
     * 该评论的子评论
     */
    @ApiModelProperty("该评论的子评论")
    @TableField(exist = false)
    private List<Comment> commentList;

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

}
