package com.HexTechGDUT.service;

import com.HexTechGDUT.po.Tips;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface TipsService {

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
     * @return article
     */
    Tips queryTipsById(String id);

    /**
     * 通过uid查询该用户发表过的文章list
     * @param uid uid
     * @return article list
     */
    List<Tips> queryTipsByUid(String uid);

    /**
     * 通过文章类型查询文章list
     * @param type String -> ArticleType
     * @return article list
     */
    List<Tips> queryTipsByArticleType(String type);
}
