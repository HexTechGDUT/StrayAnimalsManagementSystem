package com.HexTechGDUT.po.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 动物的图片
 * 图片本身可能很大
 * 将图片的路径存入数据库
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AnimalPicture {

    /**
     * 图片存储位置的前缀
     */
    private static String prefix = "";

    /**
     * 图片所属的动物id
     */
    private String animalId;

    /**
     * 图片存储位置
     */
    private String picLocate;

    /**
     * 图片上传时间
     */
    private LocalDateTime uploadTime;
}
