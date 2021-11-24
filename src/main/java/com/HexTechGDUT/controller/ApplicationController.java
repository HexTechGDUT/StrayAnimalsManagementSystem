package com.HexTechGDUT.controller;

import com.HexTechGDUT.po.Application;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.service.ApplicationService;
import com.HexTechGDUT.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @AuthToken
    @PostMapping("/apply")
    public Result<Application> apply(@Validated @RequestBody Application application){
        if (applicationService.apply(application)) {
            return ResultUtils.successWithInfo(application,"提交成功");
        }
        return ResultUtils.failWithInfo(null,"提交失败");
    }

    @AuthToken
    @PostMapping("/cancle")
    public Result<String> cancle(@Validated @RequestBody String id){
        if (applicationService.cancel(id)) {
            return ResultUtils.success("取消成功");
        }
        return ResultUtils.fail("取消失败");
    }

    @AuthToken
    @PostMapping("/process")
    public Result<String> process(@Validated @RequestBody Application application){
        if (applicationService.process(application)) {
            return ResultUtils.success("处理成功");
        }
        return ResultUtils.fail("处理失败");
    }

    @AuthToken
    @GetMapping("/queryApplicationById")
    public Result<Application> queryApplicationById(@Validated @RequestParam("id") int id){
        Application application = applicationService.queryApplicationById(id);
        if (application == null) {
            return ResultUtils.failWithInfo(application,"申请不存在");
        }
        return ResultUtils.success(application);
    }

    @AuthToken
    @PostMapping("/queryApplicationByAnimalId")
    public  Result<List<Application>> queryApplicationByAnimalId(@Validated @RequestBody String animalId){
        List<Application> applicationList = applicationService.queryApplicationByAnimalId(animalId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该动物相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

    @AuthToken
    @GetMapping("/queryApplicationByStatus")
    public  Result<List<Application>> queryApplicationByStatus(@Validated @RequestParam("status") int status){
        List<Application> applicationList = applicationService.queryApplicationByStatus(status);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

    @AuthToken
    @GetMapping("/queryApplicationByUserId")
    public  Result<List<Application>> queryApplicationByUserId(@Validated @RequestBody String userId){
        List<Application> applicationList = applicationService.queryApplicationByUserId(userId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该用户相关的申请");
        }
        return ResultUtils.success(applicationList);
    }
}
