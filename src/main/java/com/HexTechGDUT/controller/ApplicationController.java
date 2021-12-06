package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.service.ApplicationService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author HexTechGDUT
 */
@Api("申请")
@CrossOrigin
@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Resource
    private ApplicationService applicationService;

//    @AuthToken
    @ApiOperation("提交申请")
    @PostMapping("/apply")
    public Result<Application> apply(@Validated @RequestBody Application application){
        boolean isSuccess = applicationService.apply(application) == 1;
        if (isSuccess) {
            return ResultUtils.successWithInfo(application,"提交成功");
        }
        return ResultUtils.failWithInfo(null,"提交失败");
    }

//    @AuthToken
    @ApiOperation("取消申请")
    @PostMapping("/cancel")
    public Result<String> cancel(@Validated @RequestBody int id){
        if (applicationService.cancel(id) == 1) {
            return ResultUtils.success("取消成功");
        }
        return ResultUtils.fail("取消失败");
    }

//    @AuthToken
    @ApiOperation("用户修改申请")
    @PostMapping("/update")
    public Result<String> update(@Validated @RequestBody Application application){
        boolean isSuccess = applicationService.update(application) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

//    @AuthToken(value = 1)
    @ApiOperation("管理员处理申请")
    @PostMapping("/process")
    public Result<String> process(@Validated @RequestBody Application application){
        if (applicationService.process(application) == 1) {
            return ResultUtils.success("处理成功");
        }
        return ResultUtils.fail("处理失败");
    }

//    @AuthToken
    @ApiOperation("通过申请id查询申请")
    @PostMapping("/queryApplicationById")
    public Result<Application> queryApplicationById(@Validated @RequestBody int id){
        Application application = applicationService.queryApplicationById(id);
        if (application == null) {
            return ResultUtils.failWithInfo(null,"申请不存在");
        }
        return ResultUtils.success(application);
    }

//    @AuthToken
    @ApiOperation("通过动物id查询申请")
    @PostMapping("/queryApplicationByAnimalId")
    public  Result<List<Application>> queryApplicationByAnimalId(@Validated @RequestBody int animalId){
        List<Application> applicationList = applicationService.queryApplicationByAnimalId(animalId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该动物相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

//    @AuthToken
    @ApiOperation("通过申请状态查询申请")
    @PostMapping("/queryApplicationByStatus")
    public  Result<List<Application>> queryApplicationByStatus(@Validated @RequestBody int status){
        List<Application> applicationList = applicationService.queryApplicationByStatus(status);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

//    @AuthToken
    @ApiOperation("通过用户id查询申请")
    @PostMapping("/queryApplicationByUserId")
    public  Result<List<Application>> queryApplicationByUserId(@Validated @RequestBody String userId){
        List<Application> applicationList = applicationService.queryApplicationByUserId(userId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该用户相关的申请");
        }
        return ResultUtils.success(applicationList);
    }
}
