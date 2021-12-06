package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TokenServiceTest {

    @Resource
    TokenService tokenService;

    @Test
    public void generateAndVerifyTest(){
        User user = new User();
        user.setUserId("testu1");
        user.setPassword("testp1");
        user.setUserType(1);
        String token = tokenService.generate(user);
        System.out.println(token);
        try{
            tokenService.verify(token);
            System.out.println("token verify success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void getTokenUserIdTest(){
        User user = new User();
        user.setUserId("test_u1");
        user.setPassword("test_p1");
        user.setUserType(1);
        String token = tokenService.generate(user);
        System.out.println(tokenService.getTokenUserId(token));
    }
}
