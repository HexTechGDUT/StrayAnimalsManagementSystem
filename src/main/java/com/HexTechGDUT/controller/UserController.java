package com.HexTechGDUT.controller;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.result.ResultType;
import com.HexTechGDUT.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author HexTechGDUT
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserLoginBo> login(@Validated @RequestBody LoginBo loginBo){
        UserLoginBo userLoginBo = userService.login(loginBo);
        if(userLoginBo!=null){
            return new Result<>(ResultType.SUCCESS.getCode(), "登录成功", userLoginBo);
        }
        return new Result<>(ResultType.FAIL.getCode(), "登录失败", null);
    }
}
