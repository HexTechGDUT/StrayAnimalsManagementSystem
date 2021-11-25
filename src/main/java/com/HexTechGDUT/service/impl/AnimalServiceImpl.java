package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.AnimalMapper;
import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.service.AnimalService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class AnimalServiceImpl extends ServiceImpl<AnimalMapper, AnimalRecord> implements AnimalService{
    /**
     * 动物登记;
     *
     * @param animal 要登记的动物
     * @return 是否登记成功
     */
    @Override
    public int register(AnimalRecord animal) {
        return baseMapper.insert(animal);
    }

    /**
     * 动物信息更新;
     *
     * @param animal 要更新信息的动物
     * @return 是否更新成功
     */
    @Override
    public int update(AnimalRecord animal) {
        return baseMapper.updateById(animal);
    }

    /**
     * 通过动物昵称查询动物
     * @param animalNickname 动物昵称
     * @return animal
     */
    @Override
    public List<AnimalRecord> queryAnimalByAnimalNickname(String animalNickname) {
        QueryWrapper<AnimalRecord> wrapper = new QueryWrapper<>();
        wrapper.like("animal_nickname",animalNickname);
        return baseMapper.selectList(wrapper);
    }

    /**
     * 通过动物id查询动物;
     *
     * @param animalId animalId
     * @return animal
     */
    @Override
    public AnimalRecord queryAnimalByAnimalId(String animalId) {
        return null;
    }

    /**
     * 通过上传者id查询动物list;
     *
     * @param userId userId
     * @return animal list
     */
    @Override
    public List<AnimalRecord> queryAnimalByUserId(String userId) {
        return null;
    }

    /**
     * 根据动物状态查询动物list;
     *
     * @param status String -> AnimalStatus
     * @return animal list
     */
    @Override
    public List<AnimalRecord> queryAnimalByStatus(String status) {
        return null;
    }

    /**
     * 根据地区查询动物list;
     *
     * @param address address
     * @return animal list
     */
    @Override
    public List<AnimalRecord> queryAnimalLikeAddress(String address) {
        return null;
    }



}
