package com.HexTechGDUT.entity.bo;


import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.entity.po.Application;
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
@ApiModel(value = "用于申请分页查询的Bo", description = "由于分页查询需要同时返回记录数，故创建此Bo")
public class PageQueryApplicationBo {
    private long total;

    private List<QueryAllApplicationsBo> records;
}
