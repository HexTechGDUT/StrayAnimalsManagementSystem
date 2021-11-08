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
}
