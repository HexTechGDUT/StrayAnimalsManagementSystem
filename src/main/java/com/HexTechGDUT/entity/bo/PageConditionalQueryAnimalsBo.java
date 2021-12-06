package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用于地图页面条件查询动物的Bo", description = "用于地图页面条件查询动物，前端需要返回总页数")
public class PageConditionalQueryAnimalsBo {

    private List<ConditionalQueryAnimalsBo> animalList;

    private Long totalRecordsNum;
}
