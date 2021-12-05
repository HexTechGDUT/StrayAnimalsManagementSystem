package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.ApplicationMapper;
import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.service.ApplicationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int apply(Application application) {
        return baseMapper.insert(application);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Application application){
        if(application.getStatus() != 0){
            //申请已被处理,不可更改
            return 0;
        }
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        application.setStatus(0);
        wrapper.eq("id", application.getId());
        return baseMapper.update(application, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int process(Application application) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id",application.getId());
        return baseMapper.update(application,wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int cancel(int id) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Application application = baseMapper.selectOne(wrapper);
        if (application.getStatus() == 0) {
            application.setStatus(3);
            return baseMapper.update(application, wrapper);
        }
        return 0;
    }

    @Override
    public Application queryApplicationById(int id) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<Application> queryApplicationByAnimalId(int animalId) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("animal_record_id",animalId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Application> queryApplicationByStatus(int status) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("status",status);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Application> queryApplicationByUserId(String userId) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return baseMapper.selectList(wrapper);
    }
}
