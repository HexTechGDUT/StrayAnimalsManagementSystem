package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 对动物的评论
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("Comment")
@TableName("comment")
public class Comment {

    /**
     * 评论id
     */
    @TableId("id")
    private String id;

    /**
     * 评论所属的动物id
     */
    @TableField("animal_id")
    private String animalId;

    /**
     * 发布评论的用户id
     */
    @TableField("uid")
    private String uid;

    /**
     * 若该评论为另一条评论的子评论
     * 该属性记录该评论的父评论
     */
    @TableField("parent_id")
    private String parentCommentId;

    /**
     * 该评论的子评论
     * 在连接查询时使用
     */
    private List<Comment> commentList;

    /**
     * 评论的具体内容
     */
    @TableField("comment_str")
    private String commentStr;

    /**
     * 评论发布的时间
     */
    @TableField("publish_time")
    private LocalDateTime publishTime;

}
