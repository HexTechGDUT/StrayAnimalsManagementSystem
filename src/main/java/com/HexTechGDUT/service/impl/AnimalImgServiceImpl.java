package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.AnimalImgMapper;
import com.HexTechGDUT.entity.po.AnimalImg;
import com.HexTechGDUT.service.AnimalImgService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalImgServiceImpl extends ServiceImpl<AnimalImgMapper, AnimalImg> implements AnimalImgService {
    /**
     * 添加动物照片
     *
     * @param picture 照片路径
     * @return 是否添加成功
     */
    @Override
    public int addImg(AnimalImg picture) {
        return baseMapper.insert(picture);
    }

    /**
     * 删除动物图片
     *
     * @param id 图片id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteImg(String id) {
        return false;
    }

    /**
     * 根据动物id查询这个动物所有的图片
     *
     * @param animalId 动物id
     * @return animalImgList 动物图片的List
     */
    @Override
    public List<AnimalImg> queryAnimalImgListByAnimalId(int animalId) {
        QueryWrapper<AnimalImg> wrapper = new QueryWrapper<>();
        wrapper.eq("animal_record_id",animalId);
        return baseMapper.selectList(wrapper);
    }


}
