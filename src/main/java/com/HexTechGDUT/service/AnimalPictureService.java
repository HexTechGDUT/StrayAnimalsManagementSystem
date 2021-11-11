package com.HexTechGDUT.service;

import com.HexTechGDUT.po.animal.AnimalPicture;

/**
 * @author HexTechGDUT
 */
public interface AnimalPictureService {

    /**
     * 添加动物照片
     * @param picture 照片路径
     * @return 是否添加成功
     */
    boolean addPicture(AnimalPicture picture);

    /**
     * 删除动物图片
     * @param id 图片id
     * @return 是否删除成功
     */
    boolean deletePicture(String id);

}
