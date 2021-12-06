package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.bo.PageQueryApplicationBo;
import com.HexTechGDUT.entity.bo.QueryAllApplicationsBo;
import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.service.AnimalService;
import com.HexTechGDUT.service.ApplicationService;
import com.HexTechGDUT.service.TokenService;
import com.HexTechGDUT.utils.ResultUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
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

    @Resource
    private TokenService tokenService;

    @AuthToken
    @ApiOperation("用户提交申请")
    @PostMapping("/apply")
    public Result<Application> apply(@RequestBody Application application,@RequestBody String token){
        String userId = tokenService.getTokenUserId(token);
        application.setUserId(userId);
        application.setStatus(0);
        boolean isSuccess = applicationService.apply(application) == 1;
        if (isSuccess) {
            return ResultUtils.successWithInfo(application,"提交成功");
        }
        return ResultUtils.failWithInfo(null,"提交失败");
    }

    @AuthToken
    @ApiOperation("用户取消申请")
    @PostMapping("/cancel")
    public Result<String> cancel(@Validated @RequestBody int id){
        if (applicationService.cancel(id) == 1) {
            return ResultUtils.success("取消成功");
        }
        return ResultUtils.fail("取消失败");
    }

    @AuthToken
    @ApiOperation("用户修改申请")
    @PostMapping("/update")
    public Result<String> update(@Validated @RequestBody Application application){
        boolean isSuccess = applicationService.update(application) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

    @AuthToken(value = 1)
    @ApiOperation("管理员通过申请")
    @PostMapping("/pass")
    public String process(@Validated @RequestBody Application application,int status){
        return null;
    }

    @AuthToken(value = 1)
    @ApiOperation("管理员驳回申请")
    @PostMapping("/refused")
    public String process(@Validated @RequestBody Application application){
        return null;
    }

    @AuthToken
    @ApiOperation("通过申请id查询申请")
    @PostMapping("/queryApplicationById")
    public Result<Application> queryApplicationById(@Validated @RequestBody int id){
        Application application = applicationService.queryApplicationById(id);
        if (application == null) {
            return ResultUtils.failWithInfo(null,"申请不存在");
        }
        return ResultUtils.success(application);
    }

    @AuthToken(value = 1)
    @ApiOperation("管理员查询所有申请")
    @PostMapping("/queryAll")
    public Result<PageQueryApplicationBo> queryAllApplication(long current, long limit){
        PageQueryApplicationBo pageBo = new PageQueryApplicationBo();
        List<QueryAllApplicationsBo> bos = new ArrayList<>();
        Page<Application> page = new Page<>(current, limit);
        applicationService.page(page,null);
        List<Application> records = page.getRecords();
        for (Application application: records) {
            QueryAllApplicationsBo bo = new QueryAllApplicationsBo();
            bo.setId(application.getId());
            bo.setStatus(application.getStatus());
            bo.setCreateTime(application.getCreateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            bos.add(bo);
        }
        pageBo.setRecords(bos);
        pageBo.setTotal(page.getTotal());
        return ResultUtils.success(pageBo);
    }

    @AuthToken(value = 1)
    @ApiOperation("通过各种条件查询申请")
    @PostMapping("/queryApplication")
    public Result<PageQueryApplicationBo> queryApplication(long current,long limit,@RequestBody Application application){
        return null;
    }

    @AuthToken
    @ApiOperation("通过动物id查询申请")
    @PostMapping("/queryApplicationByAnimalId")
    public Result<List<Application>> queryApplicationByAnimalId(int current,int limit,@RequestBody int animalId){
        List<QueryAllApplicationsBo> bos = new ArrayList<>();
        Page<Application> page = new Page<>(current, limit);
        applicationService.page(page,null);
        List<Application> applicationList = applicationService.queryApplicationByAnimalId(animalId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该动物相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

    @AuthToken
    @ApiOperation("通过申请状态查询申请")
    @PostMapping("/queryApplicationByStatus")
    public Result<List<Application>> queryApplicationByStatus(@Validated @RequestBody int status){
        List<Application> applicationList = applicationService.queryApplicationByStatus(status);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有相关的申请");
        }
        return ResultUtils.success(applicationList);
    }

    @AuthToken
    @ApiOperation("通过用户id查询申请")
    @PostMapping("/queryApplicationByUserId")
    public Result<List<Application>> queryApplicationByUserId(@Validated @RequestBody String token){
        String userId = tokenService.getTokenUserId(token);
        List<Application> applicationList = applicationService.queryApplicationByUserId(userId);
        if (applicationList.isEmpty()) {
            return ResultUtils.failWithInfo(null,"没有该用户相关的申请");
        }
        return ResultUtils.success(applicationList);
    }
}
