package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.TipsMapper;
import com.HexTechGDUT.entity.po.Tips;
import com.HexTechGDUT.service.TipsService;
import com.HexTechGDUT.utils.RandomUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class TipsServiceImpl extends ServiceImpl<TipsMapper, Tips> implements TipsService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Tips tips) {
        return baseMapper.insert(tips);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Tips tips) {
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        wrapper.eq("id", tips.getId());
        return baseMapper.update(tips, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int id) {
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return baseMapper.delete(wrapper);
    }

    @Override
    public List<Tips> queryAllTips(){
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        return baseMapper.selectList(wrapper);
    }

    @Override
    public Tips queryRandomTips(){
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        List<Tips> tipsList = baseMapper.selectList(wrapper);
        return tipsList.get(RandomUtils.randomInt(tipsList.size()-1));
    }

    @Override
    public Tips queryTipsById(int id) {
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<Tips> queryTipsLikeTitle(String title) {
        QueryWrapper<Tips> wrapper = new QueryWrapper<>();
        wrapper.like("title", title);
        return baseMapper.selectList(wrapper);
    }
}
