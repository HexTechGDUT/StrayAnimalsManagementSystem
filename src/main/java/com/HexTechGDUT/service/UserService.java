package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.bo.UidAndPwdBo;
import com.HexTechGDUT.entity.bo.UserLoginBo;
import com.HexTechGDUT.entity.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     * @param uidAndPwdBo 注册用户
     * @return 是否注册成功
     */
    int register(UidAndPwdBo uidAndPwdBo);

    /**
     * 用户登录
     * @param uidAndPwdBo 登录帐号和密码
     * @return String token
     */
    UserLoginBo login(UidAndPwdBo uidAndPwdBo);

    /**
     * 用户信息更新
     * @param user 更新信息的用户
     * @return 是否更新成功
     */
    int updateUser(User user);

    /**
     * 删除用户
     * 将userType设为-1
     * @param userId userId
     * @return 是否删除成功
     */
    int deleteUser(String userId);

    /**
     * 通过userid查询用户
     * @param userid uid
     * @return User
     */
    User queryUserByUserId(String userid);

    /**
     * 通过名字模糊查询用户
     * @param name name
     * @return user list
     */
    List<User> queryUserLikeName(String name);

    /**
     * 根据地址模糊查询地址周围的用户
     * @param address address
     * @return user list
     */
    List<User> queryUserLikeAddress(String address);

    /**
     * 根据用户权限查询所有相同权限的用户
     * @param type type
     * @return user list
     */
    List<User> queryUserByUserType(int type);
}
