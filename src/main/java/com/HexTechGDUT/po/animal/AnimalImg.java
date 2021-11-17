package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class AnimalImg {

    /**
     * 图片id
     */
    @TableId("id")
    private int id;

    /**
     * 图片存储位置的前缀
     */
    @TableField(exist = false)
    private static String prefix = "";

    /**
     * 图片所属的动物id
     */
    @TableField("animal_record_id")
    private String animalRecordId;

    /**
     * 图片名字
     */
    @TableField("name")
    @Size(max = 16)
    private String name;

    /**
     * 图片具体存储位置
     */
    @Size(max = 50)
    @TableField("path")
    private String path;

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
