package com.HexTechGDUT.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author HexTechGDUT
 */
@Data
public class AnimalQuery {

    @ApiModelProperty(value = "最后出现的地址的索引")
    @TableField("last_address_index")
    private String lastAddressIndex;

    @ApiModelProperty(value = "1=流浪动物 2=走失动物 3=弃养动物")
    @TableField("status")
    private int status;

}
