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
     * @throws Exception e
     */
    void verify(String token) throws Exception;
}
