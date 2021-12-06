package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.bo.UidAndPwdBo;
import com.HexTechGDUT.entity.po.User;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.TokenService;
import com.HexTechGDUT.service.UserService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @Resource
    private TokenService tokenService;

//    @PassToken
    @ApiOperation("注册")
    @PostMapping("/register")
    public Result<String> register(@Validated @RequestBody UidAndPwdBo uidAndPwdBo){
        boolean isSuccess = userService.register(uidAndPwdBo) == 1;
        if(isSuccess){
            return ResultUtils.successWithInfo(userService.login(uidAndPwdBo), "注册成功");
        }
        return ResultUtils.failWithInfo(null, "注册失败");
    }

//    @PassToken
    @ApiOperation("登录")
    @PostMapping("/login")
    public Result<String> login(@Validated @RequestBody UidAndPwdBo uidAndPwdBo){
        return ResultUtils.successWithInfo(userService.login(uidAndPwdBo), "登录成功");
    }

    @ApiOperation("刷新token的过期时间")
    @PostMapping("refreshToken")
    public Result<String> refreshToken(@Validated @RequestBody String oldToken){
        return ResultUtils.success(tokenService.refresh(oldToken));
    }

//    @PassToken
    @ApiOperation("根据token获取用户id")
    @PostMapping("getUserIdByToken")
    public Result<String> getUserIdByToken(@Validated @RequestBody String token){
        return ResultUtils.success(tokenService.getTokenUserId(token));
    }

//    @AuthToken
    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public Result<String> update(@Validated @RequestBody User user){
        boolean isSuccess = userService.updateUser(user) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

//    @AuthToken
    @ApiOperation("删除用户")
    @ApiImplicitParam(name = "userId", value = "要删除的用户id", dataType = "String", required = true)
    @PostMapping("/delete")
    private Result<String> deleteUser(@Validated @RequestBody String userId){
        boolean isSuccess = userService.deleteUser(userId) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

//    @PassToken
    @ApiOperation("通过请求头携带的token查询用户")
    @PostMapping("queryUserByToken")
    public Result<User> queryUserByToken(@Validated @RequestBody String token){
        User user = userService.queryUserByUserId(tokenService.getTokenUserId(token));
        if(user == null){
            return ResultUtils.failWithInfo(null, "用户不存在");
        }
        user.setPassword("");
        return ResultUtils.success(user);
    }

//    @AuthToken(value = 1)
//    @ApiOperation("通过用户id查询用户")
//    @ApiImplicitParam(name = "userId", value = "用户id", dataType = "String", required = true)
//    @PostMapping("/queryUserByUserId")
//    public Result<User> queryUserByUserId(@Validated @RequestBody String userId){
//        User user = userService.queryUserByUserId(userId);
//        if(user == null){
//            return ResultUtils.failWithInfo(null, "用户不存在");
//        }
//        user.setPassword("");
//        return ResultUtils.success(user);
//    }

//    @AuthToken(value = 1)
    @ApiOperation("通过名字模糊查询用户")
    @ApiImplicitParam(name = "name", value = "用户名", dataType = "String", required = true)
    @PostMapping("/queryUserLikeName")
    public Result<List<User>> queryUserLikeName(@Validated @RequestBody String name){
        List<User> userList = userService.queryUserLikeName(name);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }

//    @AuthToken(value = 1)
    @ApiOperation("通过地址模糊查询用户")
    @ApiImplicitParam(name = "address", value = "用户联系地址", dataType = "String", required = true)
    @PostMapping("/queryUserLikeAddress")
    public Result<List<User>> queryUserLikeAddress(@Validated @RequestBody String address){
        List<User> userList = userService.queryUserLikeAddress(address);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }

//    @AuthToken(value = 1)
    @ApiOperation("通过用户权限查询用户")
    @ApiImplicitParam(name = "type", value = "用户类型：1-管理员,0-普通用户", dataType = "Integer", required = true)
    @PostMapping("/queryUserByUserType")
    public Result<List<User>> queryUserByUserType(@Validated @RequestBody int type){
        List<User> userList = userService.queryUserByUserType(type);
        if(userList == null || userList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        for (User user : userList) {
            user.setPassword("");
        }
        return ResultUtils.success(userList);
    }
}
