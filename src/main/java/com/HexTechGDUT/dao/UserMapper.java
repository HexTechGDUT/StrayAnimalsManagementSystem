package com.HexTechGDUT.dao;

import com.HexTechGDUT.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 新增用户;
     * @param user user
     * @return 是否成功
     */
    boolean addUser(User user);

    /**
     * 通过uid删除用户;
     * @param uid uid
     * @return 是否删除成功
     */
    boolean deleteUser(String uid);

    /**
     * 根据相似名字查询用户;
     * @param name 名字
     * @return 用户List
     */
    List<User> queryUserLikeName(String name);

    /**
     * 通过地址模糊查询附近用户;
     * @param address address
     * @return user list
     */
    List<User> queryUserLikeAddress(String address);

    /**
     * 根据用户类型查询用户;
     * 管理员‘1’ & 普通用户‘0’;
     * @param type type
     * @return user list
     */
    List<User> queryUserByUserType(int type);

}
