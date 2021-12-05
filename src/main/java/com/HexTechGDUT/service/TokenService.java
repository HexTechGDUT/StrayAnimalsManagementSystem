package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.User;

/**
 * token相关的接口
 * 允许实现自定义token
 * @author HexTechGDUT
 */
public interface TokenService{

    /**
     * 生成token
     * @param user user
     * @return String token
     */
    String generate(User user);

    /**
     * 验证Token
     * 验证成功什么也不做
     * 验证失败抛出异常
     * @param token token
     */
    void verify(String token);

    /**
     * 不验证token,直接获取token中的用户id
     * 通常用于验证完token后验证用户是否存在
     * @param token token
     * @return uid
     */
    String getTokenUid(String token);
}
