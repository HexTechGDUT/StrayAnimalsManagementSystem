package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用于动物分页查询的Bo", description = "此接口用于在地图页面上显示条件查询的结果")
public class ConditionalQueryAnimalsBo {

    /**
     * 动物昵称
     */
    public String animalNickname;

    /**
     * 动物种类
     */
    public String animalType;

    /**
     * 最后发现时间
     */
    public String updateTime;

    /**
     * 图片路径
     */
    public String imgUrl;
}
