package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.CommentMapper;
import com.HexTechGDUT.entity.po.Comment;
import com.HexTechGDUT.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int publish(Comment comment) {
        return baseMapper.insert(comment);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int delete(int id) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        return baseMapper.delete(wrapper);
    }

    @Override
    public List<Comment> queryCommentByAnimalId(int animalId) {
        //该方法未能查询回复评论
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("animal_record_id",animalId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Comment> queryCommentByUserId(String userId) {
        //该方法未能查询回复评论
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        return baseMapper.selectList(wrapper);
    }
}
