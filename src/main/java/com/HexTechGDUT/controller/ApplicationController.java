package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.bo.ApplicationListBo;
import com.HexTechGDUT.entity.bo.PageQueryApplicationBo;
import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.TokenService;
import com.HexTechGDUT.service.AnimalService;
import com.HexTechGDUT.service.ApplicationService;
import com.HexTechGDUT.utils.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @Resource
    private AnimalService animalService;

    // @AuthToken
    @ApiOperation("用户提交申请")
    @PostMapping("/apply")
    public Result<Application> apply(@RequestBody Application application,@RequestHeader("token") String token){
        String userId = tokenService.getTokenUserId(token);
        application.setUserId(userId);
        boolean isSuccess = applicationService.apply(application) == 1;
        if (isSuccess) {
            return ResultUtils.successWithInfo(application,"提交成功");
        }
        return ResultUtils.failWithInfo(null,"提交失败");
    }

    // @AuthToken
    @ApiOperation("用户取消申请")
    @GetMapping("/cancel")
    public Result<String> cancel(@RequestParam int id){
        if (applicationService.cancel(id) == 1) {
            return ResultUtils.success("取消成功");
        }
        return ResultUtils.fail("取消失败");
    }

    // @AuthToken
    @ApiOperation("用户修改申请")
    @PostMapping("/update")
    public Result<String> update(@Validated @RequestBody Application application){
        boolean isSuccess = applicationService.update(application) == 1;
        if(isSuccess){
            return ResultUtils.success("更新成功");
        }
        return ResultUtils.fail("更新失败");
    }

    // @AuthToken
    @ApiOperation("通过申请id查询申请")
    @GetMapping("/queryApplicationById")
    public Result<Application> queryApplicationById(@RequestParam int id){
        Application application = applicationService.queryApplicationById(id);
        if (application == null) {
            return ResultUtils.failWithInfo(null,"申请不存在");
        }
        return ResultUtils.success(application);
    }

    // @AuthToken(value = 1)
    @ApiOperation("管理员查询所有申请")
    @PostMapping("/queryAll")
    public Result<PageQueryApplicationBo> queryAllApplication(long current, long limit){
        PageQueryApplicationBo pageBo = new PageQueryApplicationBo();
        List<ApplicationListBo> bos = new ArrayList<>();
        Page<Application> page = new Page<>(current, limit);
        applicationService.page(page,null);
        List<Application> records = page.getRecords();
        for (Application application: records) {
            ApplicationListBo bo = new ApplicationListBo();
            bo.setApplicationId(application.getId());
            bo.setAnimalNickname(animalService.getAnimalByApplicationId(application.getId()).getAnimalNickname());
            bo.setStatus(application.getStatus());
            bo.setImgUrl(animalService.getAnimalByApplicationId(application.getId()).getAnimalImgList().get(0).getPath());
            bo.setUpdateTime(application.getUpdateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            bos.add(bo);
        }
        pageBo.setRecords(bos);
        pageBo.setTotal(page.getTotal());
        return ResultUtils.success(pageBo);
    }

    // @AuthToken(value = 1)
    @ApiOperation("通过各种条件查询申请")
    @PostMapping("/queryApplication")
    public Result<PageQueryApplicationBo> queryApplication(long current,
                                                           long limit,
                                                           int animalId,
                                                           int status,
                                                           int type,
                                                           @RequestHeader("token") String token){

        PageQueryApplicationBo pageBo = new PageQueryApplicationBo();
        List<ApplicationListBo> bos = new ArrayList<>();
        Page<Application> page = new Page<>(current, limit);
        QueryWrapper<Application> wrapper = new QueryWrapper<>();
        if (animalId != 0) {
            wrapper.eq("animal_record_id",animalId);
        }
        if (status != 0) {
            wrapper.eq("status",status);
        }
        if (!token.equals("NaN")) {
            String userId = tokenService.getTokenUserId(token);
            wrapper.eq("userId",userId);
        }
        if (type != 0) {
            wrapper.eq("type",type);
        }
        wrapper.orderByDesc("update_time");
        applicationService.page(page, wrapper);
        List<Application> records = page.getRecords();
        if (records.isEmpty()) {
            return ResultUtils.failWithInfo(null,"查询失败");
        }
        for (Application a: records) {
            ApplicationListBo bo = new ApplicationListBo();
            bo.setApplicationId(a.getId());
            bo.setAnimalNickname(animalService.getAnimalByApplicationId(a.getId()).getAnimalNickname());
            bo.setStatus(a.getStatus());
            bo.setImgUrl(animalService.getAnimalByApplicationId(a.getId()).getAnimalImgList().get(0).getPath());
            bo.setUpdateTime(a.getUpdateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            bos.add(bo);
        }
        pageBo.setRecords(bos);
        pageBo.setTotal(page.getTotal());
        return ResultUtils.success(pageBo);
    }
}
