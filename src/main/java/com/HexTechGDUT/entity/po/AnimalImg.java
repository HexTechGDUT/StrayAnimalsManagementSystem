package com.HexTechGDUT.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 动物的图片
 * 图片本身可能很大
 * 将图片的存放路径存入数据库
 * 取出后根据( 前缀prefix + 具体路径picLocate )在服务器上查找即可
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("AnimalImg")
@TableName("animal_img")
@ApiModel("动物图片")
public class AnimalImg {

    /**
     * 图片id
     */
    @ApiModelProperty("id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    /**
     * 图片所属的动物id
     */
    @ApiModelProperty("图片所属的动物id")
    @TableField("animal_record_id")
    private Integer animalRecordId;

    /**
     * 图片的宽高比
     */
    @ApiModelProperty("图片的宽高比")
    @TableField("aspect_ratio")
    private String aspectRatio;

    /**
     * 图片具体存储位置
     */
    @ApiModelProperty("图片具体存储位置")
    @TableField("path")
    private String path;

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
