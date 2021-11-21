package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.po.Tips;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.TipsService;
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
@Api("提示")
@CrossOrigin
@RestController
@RequestMapping("/tips")
public class TipsController {

    @Resource
    TipsService tipsService;

    /**
     * 管理员才能发布文章
     * @param tips tips
     * @return result of tips
     */
    @AuthToken(value = 1)
    @ApiOperation("发布文章")
    @PostMapping("/publish")
    public Result<Tips> publish(@ApiParam("提示") @Validated @RequestBody Tips tips){
        boolean isSuccess = tipsService.insert(tips) == 1;
        if(isSuccess){
            return ResultUtils.successWithInfo(tips, "发布文章成功");
        }
        return ResultUtils.failWithInfo(null, "发布文章失败");
    }

    /**
     * 管理员才能修改文章
     * @param tips tips
     * @return result of tips
     */
    @AuthToken(value = 1)
    @ApiOperation("更新文章")
    @PostMapping("/update")
    public Result<Tips> update(@ApiParam("提示") @Validated @RequestBody Tips tips){
        boolean isSuccess = tipsService.update(tips) == 1;
        if(isSuccess){
            return ResultUtils.successWithInfo(tips, "发布文章成功");
        }
        return ResultUtils.failWithInfo(null, "发布文章失败");
    }

    /**
     * 删除tips
     * @param id tip id
     * @return 返回信息
     */
    @AuthToken(value = 1)
    @ApiOperation("删除文章")
    @PostMapping("/delete")
    public Result<String> delete(@ApiParam("tips id") @Validated @RequestBody int id){
        boolean isSuccess = tipsService.delete(id) == 1;
        if(isSuccess){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }

    /**
     * 登录即可查询tips
     * @return tips list
     */
    @PassToken
    @AuthToken
    @ApiOperation("查询全部文章")
    @PostMapping("/queryAllTips")
    public Result<List<Tips>> queryAllTips(){
        List<Tips> tipsList = tipsService.queryAllTips();
        if(tipsList == null || tipsList.isEmpty()){
            return ResultUtils.failWithInfo(null, "没有查询到相关tips");
        }
        return ResultUtils.success(tipsList);
    }

    /**
     * 登录即可查询tips
     * @param id id
     * @return tips
     */
    @PassToken
    @AuthToken
    @ApiOperation("根据文章id查询文章")
    @PostMapping("/queryTipsById")
    public Result<Tips> queryTipsById(@ApiParam("tips id") @Validated @RequestBody int id){
        Tips tips = tipsService.queryTipsById(id);
        if(tips == null){
            return ResultUtils.failWithInfo(null, "没有查询到相关tips");
        }
        return ResultUtils.success(tips);
    }

    /**
     * 登录即可查询tips
     * @param title tips 标题
     * @return tips list
     */
    @PassToken
    @AuthToken
    @ApiOperation("根据题目模糊查询文章")
    @PostMapping("/queryTipsLikeTitle")
    public Result<List<Tips>> queryTipsLikeTitle(@ApiParam("tips标题") @Validated @RequestBody String title){
        List<Tips> tipsList = tipsService.queryTipsLikeTitle(title);
        if(tipsList == null || tipsList.isEmpty()){
            return ResultUtils.failWithInfo(new ArrayList<>(), "查询结果为空");
        }
        return ResultUtils.success(tipsList);
    }

}
