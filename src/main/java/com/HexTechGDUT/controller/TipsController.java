package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.po.Tips;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.service.TipsService;
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
@Api("提示")
@CrossOrigin
@RestController
@RequestMapping("/tips")
public class TipsController {

    @Resource
    TipsService tipsService;

    @ApiOperation("发布文章")
    @PostMapping("/publish")
    public Result<Tips> publish(@Validated @RequestBody Tips tips){
        boolean isSuccess = tipsService.insert(tips) == 1;
        if(isSuccess){
            return ResultUtils.successWithInfo(tips, "发布文章成功");
        }
        return ResultUtils.failWithInfo(null, "发布文章失败");
    }

    @ApiOperation("更新文章")
    @PostMapping("/update")
    public Result<Tips> update(@Validated @RequestBody Tips tips){
        boolean isSuccess = tipsService.update(tips) == 1;
        if(isSuccess){
            return ResultUtils.successWithInfo(tips, "发布文章成功");
        }
        return ResultUtils.failWithInfo(null, "发布文章失败");
    }

    @ApiOperation("删除文章")
    @ApiImplicitParam(name = "id", value = "文章id", dataType = "Integer",required = true)
    @PostMapping("/delete")
    public Result<String> delete(@Validated @RequestBody int id){
        boolean isSuccess = tipsService.delete(id) == 1;
        if(isSuccess){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }

    @ApiOperation("查询全部文章")
    @GetMapping("/queryAllTips")
    public Result<List<Tips>> queryAllTips(){
        List<Tips> tipsList = tipsService.queryAllTips();
        if(tipsList == null || tipsList.isEmpty()){
            return ResultUtils.failWithInfo(null, "没有查询到相关tips");
        }
        return ResultUtils.success(tipsList);
    }

    @ApiOperation("随机查询一篇文章")
    @GetMapping("/queryRandomTips")
    public Result<Tips> queryRandomTips(){
        Tips tips = tipsService.queryRandomTips();
        if(tips == null){
            return ResultUtils.failWithInfo(null, "没有查询到tips");
        }
        return ResultUtils.success(tips);
    }

    @ApiOperation("根据文章id查询文章")
    @ApiImplicitParam(name = "id", value = "文章id", dataType = "Integer", required = true)
    @PostMapping("/queryTipsById")
    public Result<Tips> queryTipsById(@Validated @RequestBody int id){
        Tips tips = tipsService.queryTipsById(id);
        if(tips == null){
            return ResultUtils.failWithInfo(null, "没有查询到相关tips");
        }
        return ResultUtils.success(tips);
    }

    @ApiOperation("根据题目模糊查询文章")
    @ApiImplicitParam(name = "title", value = "标题", dataType = "String", required = true)
    @PostMapping("/queryTipsLikeTitle")
    public Result<List<Tips>> queryTipsLikeTitle(@Validated @RequestBody String title){
        List<Tips> tipsList = tipsService.queryTipsLikeTitle(title);
        if(tipsList == null || tipsList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        return ResultUtils.success(tipsList);
    }

}
