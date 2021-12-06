package com.HexTechGDUT.entity.bo;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 前端显示申请时所需的参数
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "展示所有申请时的参数", description = "仅传递展示所需要的参数")
public class QueryAllApplicationsBo {
    private Integer id;

    private int status;

    private String createTime;
}
