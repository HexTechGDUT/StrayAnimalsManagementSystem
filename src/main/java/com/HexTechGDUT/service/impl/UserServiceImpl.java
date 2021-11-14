package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.po.user.User;
import com.HexTechGDUT.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public UserLoginBo login(LoginBo loginBo) {
        User user = userMapper.queryUserByUid(loginBo.getUid());
        if(user!=null && user.getPwd().equals(loginBo.getPwd())){
            UserLoginBo userLoginBo = new UserLoginBo();
            userLoginBo.setUser(user);
            userLoginBo.setLoginToken(user.getUid());
            return userLoginBo;
        }
        return null;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(String uid) {
        return userMapper.deleteUser(uid);
    }

    @Override
    public User queryUserByUid(String uid) {
        return userMapper.queryUserByUid(uid);
    }

    @Override
    public List<User> queryUserLikeName(String name) {
        return userMapper.queryUserLikeName(name);
    }
}
