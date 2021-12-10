package com.HexTechGDUT.entity.bo;

import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.entity.vo.ApplicationQuery;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用于动物分页查询的Bo", description = "接受前端发回的参数")
public class PageAndApplicationBo {
    long current;

    long limit;

    ApplicationQuery applicationQuery;
}
