package com.HexTechGDUT.po.article;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * 文章
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Alias("Article")
@TableName("article")
public class Article {

    /**
     * 存储位置的前缀
     */
    @TableField(exist = false)
    private static String prefix = "";

    /**
     * 文章id
     */
    @TableId("id")
    private String id;

    /**
     * 文章标题
     */
    @TableField("title")
    @Size(max = 20)
    public String title;

    /**
     * 文章类型
     */
    @TableField("type")
    @EnumValue
    private ArticleType type;

    /**
     * 存储的位置
     * specific_locate = prefix + article_locate
     */
    @TableField("article_path")
    @Size(max = 50)
    private String articlePath;

    /**
     * 文章的发布者id
     */
    @TableField("uid")
    private String uid;

    /**
     * 发布时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}
