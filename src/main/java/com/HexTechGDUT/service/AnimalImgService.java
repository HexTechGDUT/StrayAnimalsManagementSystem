package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.AnimalImg;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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
    boolean deleteImg(String id);

    /**
     * 根据动物id查询这个动物所有的图片
     * @param animalId 动物id
     * @return animalImgList 动物图片的List
     */
    List<AnimalImg> queryAnimalImgListByAnimalId(int animalId);
}
