package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.bo.LoginBo;
import com.HexTechGDUT.entity.po.User;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.UserService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Api("用户")
@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @PassToken
    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<User> register(@ApiParam("用户注册信息")@Validated @RequestBody User user){
        boolean isSuccess = userService.register(user) == 1;
        user.setPassword("");
        if(isSuccess){
            return ResultUtils.successWithInfo(user, "注册成功");
        }
        return ResultUtils.failWithInfo(null, "注册失败");
    }

    @PassToken
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@ApiParam("用户登录Bo") @Validated @RequestBody LoginBo loginBo){
        return ResultUtils.successWithInfo(userService.login(loginBo), "登录成功");
    }

    @AuthToken
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public Result<String> update(@ApiParam("用户更新信息")@Validated @RequestBody User user){
        boolean isSuccess = userService.updateUser(user) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

    @AuthToken
    @PostMapping("/queryUserByUserId")
    public Result<User> queryUserByUserId(@ApiParam("用户id")@Validated @RequestBody String userId){
        User user = userService.queryUserByUserId(userId);
        if(user == null){
            return ResultUtils.failWithInfo(null, "用户不存在");
        }
        user.setPassword("");
        return ResultUtils.success(user);
    }

    @AuthToken
    @PostMapping("/queryUserLikeName")
    public Result<List<User>> queryUserLikeName(@ApiParam("用户名")@Validated @RequestBody String name){
        List<User> userList = userService.queryUserLikeName(name);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }

    @AuthToken
    @PostMapping("/queryUserLikeAddress")
    public Result<List<User>> queryUserLikeAddress(@ApiParam("联系地址")@Validated @RequestBody String address){
        List<User> userList = userService.queryUserLikeAddress(address);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }

    @AuthToken
    @PostMapping("/queryUserByUserType")
    public Result<List<User>> queryUserByUserType(@ApiParam("用户类型")@Validated @RequestBody int type){
        List<User> userList = userService.queryUserByUserType(type);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }

    @PassToken
    @ApiOperation("来到首页")
    @GetMapping("/index")
    public Result<String> toIndex(){
        return ResultUtils.success("来到首页");
    }
}
