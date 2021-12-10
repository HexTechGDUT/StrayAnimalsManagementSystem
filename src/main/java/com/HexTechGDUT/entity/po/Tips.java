package com.HexTechGDUT.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 文章
 * @author HexTechGDUT
 */

@ApiModel("文章")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("Tips")
@TableName("tips")
public class Tips {

    /**
     * 文章id
     */
    @ApiModelProperty("文章id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 文章标题
     */
    @ApiModelProperty(value = "文章标题", notes = "标题最长16字")
    @TableField("title")
    @Size(max = 16)
    public String title;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

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
