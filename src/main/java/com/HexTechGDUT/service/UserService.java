package com.HexTechGDUT.service;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.po.user.User;

/**
 * @author HexTechGDUT
 */
public interface UserService {

    /**
     * 用户注册
     * @param user 注册用户
     * @return 是否注册成功
     */
    boolean register(User user);

    /**
     * 用户登录
     * @param loginBo 登录帐号和密码
     * @return Obj 登录凭证(还不知道要返回啥)
     */
    UserLoginBo login(LoginBo loginBo);

    /**
     * 用户信息更新
     * @param user 更新信息的用户
     * @return 是否更新成功
     */
    boolean update(User user);
}
