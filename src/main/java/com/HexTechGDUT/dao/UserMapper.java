package com.HexTechGDUT.dao;

import com.HexTechGDUT.po.user.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author HexTechGDUT
 */
public interface UserMapper extends BaseMapper<User> {

    /**
     * 新增用户
     * @param user user
     * @return 是否成功
     */
    default boolean addUser(User user){
        return insert(user) == 1;
    }

    /**
     * 通过uid删除用户
     * @param uid uid
     * @return 是否删除成功
     */
    default boolean deleteUser(String uid){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getUid, uid);
        return delete(wrapper) == 1;
    }

    /**
     * mybatis-plus wrapper
     * 通过uid查询一个用户
     * @param uid uid
     * @return 用户
     */
    default User queryUserByUid(String uid){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(User::getUid)
                .select(User::getName)
                .select(User::getPwd)
                .select(User::getPhone)
                .select(User::getEmail)
                .select(User::getAuth)
                .select(User::getLastUpdateTime)
                .eq(User::getUid, uid);
        return selectOne(wrapper);
    }

    /**
     * mybatis mapper
     * 通过uid查询一个用户
     * @param uid uid
     * @return 用户
     */
    User queryUserByUidFromMapper(String uid);

    /**
     * 根据相似名字查询用户
     * @param name 名字
     * @return 用户List
     */
    default List<User> queryUserLikeName(String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(User::getUid)
                .select(User::getName)
                .select(User::getPwd)
                .select(User::getPhone)
                .select(User::getEmail)
                .select(User::getAuth)
                .select(User::getLastUpdateTime)
                .like(User::getName, name);
        return selectList(wrapper);
    }

}
