package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.Tips;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface TipsService extends IService<Tips> {

    /**
     * insert新的文章
     * @param tips tips
     * @return 是否发布成功
     */
    int insert(Tips tips);

    /**
     * 修改文章
     * @param tips tips
     * @return 是否修改成功
     */
    int update(Tips tips);

    /**
     * 删除文章
     * @param id 文章id
     * @return 是否删除成功
     */
    int delete(int id);

    /**
     * 查询全部tips
     * @return tips list
     */
    List<Tips> queryAllTips();

    /**
     * 通过id查询文章
     * @param id id
     * @return tips
     */
    Tips queryTipsById(int id);

    /**
     * 根据文章名字模糊查询文章
     * @param title title
     * @return tips
     */
    List<Tips> queryTipsLikeTitle(String title);
}
