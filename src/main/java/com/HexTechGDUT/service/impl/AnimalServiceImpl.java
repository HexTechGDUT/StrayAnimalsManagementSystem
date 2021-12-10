package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.AnimalMapper;
import com.HexTechGDUT.dao.ApplicationMapper;
import com.HexTechGDUT.entity.po.AnimalRecord;

import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.service.AnimalService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class AnimalServiceImpl extends ServiceImpl<AnimalMapper, AnimalRecord> implements AnimalService{

    @Resource
    ApplicationMapper applicationMapper;


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
    public AnimalRecord queryAnimalByAnimalId(Integer animalId) {
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

    /**
     * 通过申请的id获取动物信息
     *
     * @param applicationId 申请id
     * @return animalRecord 动物信息实体类
     */
    @Override
    public AnimalRecord getAnimalByApplicationId(Integer applicationId) {
        //首先通过id获取application对象
        Application application = applicationMapper.selectById(applicationId);
        String animalRecordJson = application.getInformation();
        JSONObject jsonObject = JSON.parseObject(animalRecordJson);
        //System.out.println("---");
        //System.out.println(jsonObject.getJSONObject("data").toJSONString());
        //System.out.println("---");
        return JSONObject.parseObject(jsonObject.getJSONObject("data").toJSONString(),AnimalRecord.class);
    }

    /**
     * 通过申请id将申请字段的状态改为已通过，由于这部分的逻辑是和增加和修改动物信息绑定在一起的，故不需要Application模块编写
     * @param applicationId 申请id
     * @return 是否成功通过申请
     */
    @Override
    public int acceptApplication(Integer applicationId){
        //首先通过id获取application对象
        Application application = applicationMapper.selectById(applicationId);
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id",applicationId);
        application.setStatus(1);
        return applicationMapper.update(application,wrapper);
    }

    /**
     * 通过申请id将申请字段的状态改为已拒绝
     * @param applicationId 申请id
     * @return 是否成功拒绝申请
     */
    @Override
    public int denyApplication(Integer applicationId){
        //首先通过id获取application对象
        Application application = applicationMapper.selectById(applicationId);
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id",applicationId);
        application.setStatus(2);
        return applicationMapper.update(application,wrapper);
    }

    /**
     * 通过用户id查询该用户的所有申请
     * @param userId 用户id
     * @return 申请列表
     */
    @Override
    public List<Application> queryApplicationListByUserId(String userId) {
        List<Application> applicationList;
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        wrapper.eq("status",2);
        applicationList = applicationMapper.selectList(wrapper);
        return applicationList;
    }

    /**
     * 将一个动物的状态改为已被领养
     *
     * @param animalId 动物id
     * @return 结果
     */
    @Override
    public int animalAdoption(Integer animalId) {
        AnimalRecord animalRecord = baseMapper.selectById(animalId);
        QueryWrapper<AnimalRecord> wrapper = new QueryWrapper<>();
        wrapper.eq("id",animalId);
        animalRecord.setStatus(1);
        return baseMapper.update(animalRecord,wrapper);
    }

}
