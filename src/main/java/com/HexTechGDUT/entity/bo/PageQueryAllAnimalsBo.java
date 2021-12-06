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
@ApiModel(value = "用于首页查询所有动物的Bo", description = "用于首页查询所有动物的Bo，前端需要返回总页数")
public class PageQueryAllAnimalsBo {

    private List<QueryAllAnimalsBo> animalList;

    private Long totalRecordsNum;
}
