package com.HexTechGDUT.service;

import com.HexTechGDUT.po.animal.Comment;

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
}
