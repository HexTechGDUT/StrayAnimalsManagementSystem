package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.AnimalImg;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author HexTechGDUT
 */
public interface AnimalImgService extends IService<AnimalImg> {

    /**
     * 添加动物照片
     * @param picture 照片路径
     * @return 是否添加成功
     */
    int addImg(AnimalImg picture);

    /**
     * 删除动物图片
     * @param id 图片id
     * @return 是否删除成功
     */
    int deleteImg(String id);

}
