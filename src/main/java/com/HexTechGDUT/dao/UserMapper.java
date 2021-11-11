package com.HexTechGDUT.dao;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.po.user.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author HexTechGDUT
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * 登录
     * @param loginBo loginBo
     * @return UserLoginBo
     */
    default UserLoginBo login(LoginBo loginBo){
        return null;
    }

    /**
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
