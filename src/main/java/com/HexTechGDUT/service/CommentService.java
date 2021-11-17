package com.HexTechGDUT.service;

import com.HexTechGDUT.po.animal.Comment;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface CommentService {

    /**
     * 发布评论(添加评论)
     * @param comment 评论
     * @return 是否发布(添加)成功
     */
    boolean publish(Comment comment);

    /**
     * 修改评论
     * 该方法只用于管理员修改不当评论
     * @param comment 评论
     * @return 是否修改成功
     */
    boolean update(Comment comment);

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
