package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.bo.UidAndPwdBo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserServiceTest {

    @Resource
    UserService userService;

    @Test
    public void loginTest(){
        UidAndPwdBo uidAndPwdBo = new UidAndPwdBo("uid0001", "password01");
        System.out.println(userService.login(uidAndPwdBo));

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
