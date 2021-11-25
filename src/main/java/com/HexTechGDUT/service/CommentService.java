package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Repository
public interface CommentService extends IService<Comment> {

    /**
     * 发布评论(添加评论)
     * @param comment 评论
     * @return 是否发布(添加)成功
     */
    int publish(Comment comment);

    /**
     * 删除评论
     * @param id 评论id
     * @return 是否删除成功
     */
    int delete(int id);

    /**
     * 通过动物id查询动物信息下的评论
     * @param animalId animalId
     * @return comment list
     */
    List<Comment> queryCommentByAnimalId(int animalId);

    /**
     * 通过用户id查询该用户发表过哪些评论
     * @param userId userId
     * @return comment list
     */
    List<Comment> queryCommentByUserId(String userId);
}
