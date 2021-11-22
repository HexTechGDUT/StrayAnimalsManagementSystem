package com.HexTechGDUT.service;

import com.HexTechGDUT.po.Comment;
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
    boolean publish(Comment comment);

    /**
     * 删除评论
     * @param comment 评论
     * @return 是否删除成功
     */
    boolean delete(Comment comment);

    /**
     * 通过动物id查询动物信息下的评论
     * @param animalId animalId
     * @return comment list
     */
    List<Comment> queryCommentByAnimalId(String animalId);

    /**
     * 通过用户id查询该用户发表过哪些评论
     * @param uid uid
     * @return comment list
     */
    List<Comment> queryCommentByUid(String uid);
}
