package com.HexTechGDUT.service;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param user 注册用户
     * @return 是否注册成功
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param loginBo 登录帐号和密码
     * @return String token
     */
    String login(LoginBo loginBo);

    /**
     * 用户信息更新
     * @param user 更新信息的用户
     * @return 是否更新成功
     */
    boolean updateUser(User user);

    /**
     * 删除用户
     * @param uid uid
     * @return 是否删除成功
     */
    boolean deleteUser(String uid);

    /**
     * 通过uid查询用户
     * @param uid uid
     * @return User
     */
    User queryUserByUid(String uid);

    /**
     * 通过名字模糊查询用户
     * @param name name
     * @return 用户list
     */
    List<User> queryUserLikeName(String name);
}
