package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.AnimalRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface AnimalService extends IService<AnimalRecord> {

    /**
     * 动物登记;
     * 插入新记录, previous_record_id为空;
     * @param animal 要登记的动物
     * @return 是否登记成功
     */
     int register(AnimalRecord animal);

    /**
     * 动物信息更新;
     * 插入新记录, 在新纪录中的previous_record_id中添加上一个记录的id;
     * @param animal 要更新信息的动物
     * @return 是否更新成功
     */
    int update(AnimalRecord animal);

    /**
     * 通过动物id查询动物;
     * 一个动物可能有多个record;
     * 查询animalId = id和previous_record_id = id的记录然后合并
     * @param animalId animalRecordId
     * @return animal
     */
    AnimalRecord queryAnimalByAnimalId(String animalId);

    /**
     * 通过上传者id查询动物list;
     * @param userId userId
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByUserId(String userId);

    /**
     * 根据动物状态查询动物list;
     * @param status status
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByStatus(String status);

    /**
     * 通过时间查询动物
     * 比如查询当天上传的动物
     * 也可以多写几个方法，查询最近几天或者几周上传的动物
     * @param date date
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByFoundDate(String date);

    /**
     * 根据地区模糊查询动物list;
     * @param address address
     * @return animal list
     */
    List<AnimalRecord> queryAnimalLikeAddress(String address);
}
