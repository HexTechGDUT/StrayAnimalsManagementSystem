package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.Tips;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface TipsService extends IService<Tips> {

    /**
     * 发布文章
     * @param article article
     * @return 是否发布成功
     */
    boolean publish(Tips article);

    /**
     * 修改文章
     * @param article article
     * @return 是否修改成功
     */
    boolean update(Tips article);

    /**
     * 删除文章
     * @param id 文章id
     * @return 是否删除成功
     */
    boolean delete(String id);

    /**
     * 通过id查询文章
     * @param id id
     * @return tips
     */
    Tips queryTipsById(String id);

    /**
     * 通过uid查询该用户发表过的文章list
     * @param userId userId
     * @return tips
     */
    List<Tips> queryTipsByUserId(String userId);

    /**
     * 根据文章名字模糊查询文章
     * @param title title
     * @return tips
     */
    List<Tips> queryTipsLikeTitle(String title);
}
