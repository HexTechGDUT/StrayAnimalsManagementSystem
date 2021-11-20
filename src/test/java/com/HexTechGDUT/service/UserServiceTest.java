package com.HexTechGDUT.service;

import com.HexTechGDUT.bo.LoginBo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void loginTest(){
        LoginBo loginBo = new LoginBo("uid0001", "password01");
        System.out.println(userService.login(loginBo));

    }

    @Test
    public void queryUserByIdTest(){
        System.out.println(userService.queryUserByUserId("uid0002"));
    }

    @Test
    public void queryUserLikeNameTest(){
        System.out.println(userService.queryUserLikeName("n1"));

    }
}
