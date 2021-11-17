package com.HexTechGDUT;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserTest {

    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    public void beanTest(){

    }

    @Test
    public void loginTest(){
        LoginBo loginBo = new LoginBo("uid0001", "password01");
        System.out.println(userService.login(loginBo));

    }

    @Test
    public void queryUserByIdTest(){
//        System.out.println(userMapper.queryUserByUid("uid0001"));
        System.out.println(userService.queryUserByUid("uid0002"));
//        System.out.println(userMapper.queryUserByUidFromMapper("uid0001"));
    }

    @Test
    public void queryUserLikeNameTest(){
        System.out.println(userService.queryUserLikeName("n1"));

    }
}
