package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.entity.bo.UidAndPwdBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.entity.po.User;
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
    public int register(UidAndPwdBo uidAndPwdBo) {
        if(userService.queryUserByUserId(uidAndPwdBo.getUserId()) != null){
            throw new RuntimeException("当前id已被使用");
        }
        User user = new User();
        user.setUserId(uidAndPwdBo.getUserId());
        user.setPassword(uidAndPwdBo.getPwd());
        return baseMapper.insert(user);
    }

    @Override
    public String login(UidAndPwdBo uidAndPwdBo) {
        User user = userService.queryUserByUserId(uidAndPwdBo.getUserId());
        if(user == null){
            throw new RuntimeException("帐号不存在");
        }
        if(!user.getPassword().equals(uidAndPwdBo.getPwd())){
            throw new RuntimeException("密码错误");
        }
        return tokenService.generate(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //更新密码可以选择另外多写一个方法，但是这里为了方便，设置所有属性都可以一起更新
        wrapper.eq("user_id", user.getUserId());
        return baseMapper.update(user, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUser(String userId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        User user = baseMapper.selectOne(wrapper);
        user.setUserType(-1);
        return baseMapper.update(user, wrapper);
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
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<User> queryUserLikeAddress(String address) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("contact_address", address);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<User> queryUserByUserType(int type) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_type", type);
        return baseMapper.selectList(wrapper);
    }
}
