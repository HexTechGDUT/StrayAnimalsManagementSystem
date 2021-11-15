package com.HexTechGDUT.po.article;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 文章的类型
 * 相关知识/功能介绍/操作指引
 * @author HexTechGDUT
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ArticleType implements IEnum<String> {

    /**
     * 相关知识
     * tips
     */
    TIPS("TIPS"),

    /**
     * 功能介绍
     * intro
     */
    INTRO("INTRO"),

    /**
     * 操作指引
     * guide
     */
    GUIDE("GUIDE");

    private String value;

    @Override
    public String getValue() {
        return value;
    }
}
