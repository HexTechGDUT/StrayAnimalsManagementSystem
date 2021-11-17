package com.HexTechGDUT.po.animal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Alias("AnimalPicture")
@TableName("animal_picture")
public class AnimalPicture {

    /**
     * 图片存储位置的前缀
     */
    @TableField(exist = false)
    private static String prefix = "";

    /**
     * 图片所属的动物id
     */
    @TableField("animal_id")
    private String animalId;

    /**
     * 图片具体存储位置
     */
    @Size(max = 50)
    @TableField("pic_path")
    private String picPath;

    /**
     * 图片上传时间
     */
    @TableField("upload_time")
    private LocalDateTime uploadTime;
}
