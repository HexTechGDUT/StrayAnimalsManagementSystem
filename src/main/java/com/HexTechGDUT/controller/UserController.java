package com.HexTechGDUT.controller;

import com.HexTechGDUT.bo.LoginBo;
import com.HexTechGDUT.bo.UserLoginBo;
import com.HexTechGDUT.po.user.User;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.service.UserService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author HexTechGDUT
 */
@Api("用户")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public @ResponseBody Result<User> register(@ApiParam("用户注册信息")@Validated @RequestBody User user){
        boolean isSuccess = userService.register(user);
        user.setPwd("");
        if(isSuccess){
            return ResultUtils.successWithInfo(user, "注册成功");
        }
        return ResultUtils.failWithInfo(user, "注册失败");
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public @ResponseBody Result<UserLoginBo> login(@ApiParam("用户登录Bo") @Validated @RequestBody LoginBo loginBo){
        UserLoginBo userLoginBo = userService.login(loginBo);
        if(userLoginBo!=null){
            return ResultUtils.successWithInfo(userLoginBo, "登录成功");
        }
        return ResultUtils.successWithInfo(null, "登录失败");
    }
}
