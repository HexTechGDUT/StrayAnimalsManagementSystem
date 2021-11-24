package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.dao.CommentMapper;
import com.HexTechGDUT.po.Comment;
import com.HexTechGDUT.service.CommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService{
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean publish(Comment comment) {
        return baseMapper.insert(comment) != 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Comment comment) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("id",comment.getId());
        return baseMapper.delete(wrapper) != 0;
    }

    @Override
    public List<Comment> queryCommentByAnimalId(String animalId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("animal_record_id",animalId);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Comment> queryCommentByUid(String uid) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",uid);
        return baseMapper.selectList(wrapper);
    }
}
