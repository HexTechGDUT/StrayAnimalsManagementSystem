package com.HexTechGDUT.entity.bo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ApiModel(value = "用于查询申请列表的Bo", description = "此接口用于在地图页面上查询申请列表")
public class ApplicationListBo {

    /**
     * 申请id
     */
    public Integer applicationId;

    /**
     * 动物昵称
     */
    public String animalNickname;

    /**
     * 图片路径
     */
    public String imgUrl;

    /**
     * 状态
     */
    public Integer status;

    /**
     * 修改时间
     */
    public String updateTime;

}
