package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.po.User;
import com.HexTechGDUT.service.TokenService;
import com.HexTechGDUT.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserService userService;

    @Resource
    private TokenService tokenService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(User user) {
        return baseMapper.addUser(user);
    }

    @Override
    public String login(LoginBo loginBo) {
        log.debug(this.getClass().getName()+"\tparam:"+loginBo.toString());
        User user = userService.queryUserByUserId(loginBo.getUid());
        if(user!=null && user.getPassword().equals(loginBo.getPwd())){
            return tokenService.generate(loginBo);
        }
        throw new RuntimeException("帐号不存在或密码错误");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("user_id", "user_name", "phone_number", "contact_address", "additional_information")
                .eq("user_id", user.getUserId());
        return baseMapper.update(user, wrapper) == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(String uid) {
        return baseMapper.deleteUser(uid);
    }

    @Override
    public User queryUserByUserId(String userId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return baseMapper.selectOne(wrapper);
    }

    @Override
    public List<User> queryUserLikeName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", name);
        return baseMapper.queryUserLikeName(name);
    }

    @Override
    public List<User> queryUserLikeContactAddress(String address) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("contact_address", address);
        return baseMapper.queryUserLikeAddress(address);
    }

    @Override
    public List<User> queryUserByUserType(int type) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_type", type);
        return baseMapper.queryUserByUserType(type);
    }
}
