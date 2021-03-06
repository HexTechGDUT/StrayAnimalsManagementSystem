package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.bo.ApplicationListBo;
import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.entity.po.Application;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HexTechGDUT
 */

public interface AnimalService extends IService<AnimalRecord>{

    /**
     * 动物登记;
     * @param animal 要登记的动物
     * @return 是否登记成功
     */
     int register(AnimalRecord animal);

    /**
     * 动物信息更新;
     * @param animal 要更新信息的动物
     * @return 是否更新成功
     */
    int update(AnimalRecord animal);

    /**
     * 通过动物昵称查询动物
     * @param animalNickname 动物昵称
     * @return animal
     */
    List<AnimalRecord> queryAnimalByAnimalNickname(String animalNickname);

    /**
     * 通过动物id查询动物;
     * @param animalId animalId
     * @return animal
     */
    AnimalRecord queryAnimalByAnimalId(Integer animalId);

    /**
     * 通过上传者id查询动物list;
     * @param userId userId
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByUserId(String userId);

    /**
     * 根据动物状态查询动物list;
     * @param status String -> AnimalStatus
     * @return animal list
     */
    List<AnimalRecord> queryAnimalByStatus(String status);

    /**
     * 根据地区模糊查询动物list;
     * @param address address
     * @return animal list
     */
    List<AnimalRecord> queryAnimalLikeAddress(String address);

    /**
     * 通过申请的id获取动物信息
     * @param applicationId 申请id
     * @return animalRecord 动物信息实体类
     */
    AnimalRecord getAnimalByApplicationId(Integer applicationId);

    int acceptApplication(Integer applicationId);

    int denyApplication(Integer applicationId);

    List<Application> queryApplicationListByUserId(String userId);

    /**
     * 将一个动物的状态改为已被领养
     * @param animalId 动物id
     * @return 结果
     */
    int animalAdoption(Integer animalId);
}
