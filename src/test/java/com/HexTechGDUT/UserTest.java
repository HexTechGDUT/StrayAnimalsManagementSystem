package com.HexTechGDUT;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.dao.UserMapper;
import com.HexTechGDUT.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
public class UserTest {

    @Resource
    UserService userService;

    @Resource
    UserMapper userMapper;

    @Test
    public void loginTest(){
//        LoginBo loginBo = new LoginBo("uid0001", "password01", LocalDateTime.now());
//        System.out.println(userMapper.queryUserByUid("uid0001"));
        System.out.println(userService.queryUserByUid("uid0001"));
//        System.out.println(userService.login(loginBo));
    }
}
