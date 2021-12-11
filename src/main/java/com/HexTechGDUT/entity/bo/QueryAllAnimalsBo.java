package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 前端首页显示所有动物时所需的参数
 * @author HexTechGDUT
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "前端首页显示所有动物时所需的参数", description = "仅传递首页展示所需要的参数")
public class QueryAllAnimalsBo {

    private Integer animalId;

    private String animalNickname;

    private String imgUrl;

    private String aspectRatio;

    private Integer status;

    private String createTime;
}
