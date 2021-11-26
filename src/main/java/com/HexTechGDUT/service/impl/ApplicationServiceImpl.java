package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.ApplicationMapper;
import com.HexTechGDUT.po.Application;
import com.HexTechGDUT.service.ApplicationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean apply(Application application) {
        return baseMapper.insert(application) != 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean process(Application application) {
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        wrapper.eq("id",application.getId());
        return baseMapper.update(application,wrapper) != 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(String id) {
        Application application = baseMapper.selectById(id);
        if (application.getStatus() == 0) {
            return baseMapper.deleteById(id) != 0;
        }
        return false;
    }

    @Override
    public Application queryApplicationById(int id) {
        return baseMapper.selectById(id);
    }

    @Override
    public List<Application> queryApplicationByAnimalId(String animalId) {
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
