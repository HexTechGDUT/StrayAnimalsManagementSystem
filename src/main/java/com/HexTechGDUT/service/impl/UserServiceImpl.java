package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.po.user.User;
import com.HexTechGDUT.service.TokenService;
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

    @Resource
    private TokenService tokenService;

    @Override
    public boolean register(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public String login(LoginBo loginBo) {
        log.debug(this.getClass().getName()+"\tparam:"+loginBo.toString());
        User user = userMapper.queryUserByUidFromMapper(loginBo.getUid());
        if(user!=null && user.getPwd().equals(loginBo.getPwd())){
            return tokenService.generate(loginBo);
        }
        throw new RuntimeException("帐号不存在或密码错误");
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
//        return userMapper.queryUserByUid(uid);
        return userMapper.queryUserByUidFromMapper(uid);
    }

    @Override
    public List<User> queryUserLikeName(String name) {
        return userMapper.queryUserLikeName(name);
    }
}
