package com.HexTechGDUT.entity.bo;

import com.HexTechGDUT.entity.po.AnimalImg;
import com.HexTechGDUT.entity.po.AnimalRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 添加新动物时,传入该Bo
 * 数据库插入动物和相关的图片路径
 * 涉及两张表的insert和update
 * @author HexTechGDUT
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "动物Bo", description = "包括动物记录和动物图片，图片可以为空，可以为多张")
public class AnimalBo {

    /**
     * 动物记录
     */
    @ApiModelProperty("动物的记录")
    @NotBlank(message = "动物不能为空")
    private AnimalRecord record;

    /**
     * 存放(和本次动物记录一起上传的)动物图片的路径
     */
    @ApiModelProperty(value = "动物的图片list", notes = "存放动物图片的路径")
    private List<AnimalImg> imgPathList;
}
