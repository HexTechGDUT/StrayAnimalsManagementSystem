package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.po.user.User;
import com.HexTechGDUT.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author HexTechGDUT
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean register(User user) {
        return false;
    }

    @Override
    public UserLoginBo login(LoginBo loginBo) {
        return userMapper.login(loginBo);
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
