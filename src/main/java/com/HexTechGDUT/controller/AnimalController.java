package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.bo.*;
import com.HexTechGDUT.entity.po.AnimalImg;
import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.entity.po.Application;
import com.HexTechGDUT.entity.vo.AnimalQuery;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.security.AuthToken;
import com.HexTechGDUT.security.PassToken;
import com.HexTechGDUT.service.AnimalImgService;
import com.HexTechGDUT.service.AnimalService;
import com.HexTechGDUT.utils.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * animal和animalImg都是动物相关,不需要设置多个接口
 * @author HexTechGDUT
 */
@Api("动物")
@CrossOrigin
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {


    @Resource
    public AnimalService animalService;

    @Resource
    public AnimalImgService animalImgService;

    /**
     * 查询所有动物
     * @return recordList 结果集
     */

    @ApiOperation("查询全部动物")
    @GetMapping("queryAll")
    public Result<PageQueryAllAnimalsBo> queryAllAnimals(Long current, Long limit){
        //创建Bo对象
        List<QueryAllAnimalsBo> boList = new ArrayList<>();
        //创建封装类Bo对象
        PageQueryAllAnimalsBo pbo = new PageQueryAllAnimalsBo();
        //创建page对象
        Page<AnimalRecord> page = new Page<>(current,limit);
        //调用方法实现分页功能
        animalService.page(page,null);
        //获取每个动物信息
        List<AnimalRecord> recordList = page.getRecords();
        //总记录数
        Long totalRecordsNum = page.getTotal();
        for (AnimalRecord animalRecord : recordList) {
            QueryAllAnimalsBo bo = new QueryAllAnimalsBo();
            Integer animalId = animalRecord.getId();
            //首页每个动物只需显示一张图片，故直接取第一张图片的url即可
            String imgUrl = animalImgService.queryAnimalImgListByAnimalId(animalRecord.getId()).get(0).getPath();
            //同理，获取该动物第一张图片的纵横比
            String aspectRatio = animalImgService.queryAnimalImgListByAnimalId(animalRecord.getId()).get(0).getAspectRatio();
            //获取结果集中每个动物的昵称
            String nickname = animalRecord.getAnimalNickname();
            //获取每个动物的状态
            Integer status = animalRecord.getStatus();
            //获取结果集中每个动物的上传时间
            LocalDateTime createTime = animalRecord.getCreateTime();
            //将上传时间转换为"年-月-日"的格式，方便前端显示
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //规范化时间
            String formatCreateTime = createTime.format(formatter);
            bo.setAnimalId(animalId);
            bo.setAspectRatio(aspectRatio);
            bo.setImgUrl(imgUrl);
            bo.setAnimalNickname(nickname);
            bo.setStatus(status);
            bo.setCreateTime(formatCreateTime);
            //将对象传给boList
            boList.add(bo);
        }
        pbo.setAnimalList(boList);
        pbo.setTotalRecordsNum(totalRecordsNum);

        return ResultUtils.success(pbo);
    }

    /**
     * 前端点入动物详情时，查询这个动物的所有信息
     * @param animalId 动物id
     * @return 结果
     */

    @ApiOperation("查询一条动物记录")
    @GetMapping("queryOneAnimal")
    public Result<AnimalRecord> queryOneAnimal(Integer animalId){
        AnimalRecord animalRecord = animalService.getById(animalId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        animalRecord.setLastFoundTime(animalRecord.getUpdateTime().format(formatter));
        animalRecord.setAnimalImgList(animalImgService.queryAnimalImgListByAnimalId(animalRecord.getId()));
        return ResultUtils.success(animalRecord);
    }

    /**
     * 申请通过后，将application对象里的动物信息属性取出，插入一条动物信息
     * @param applicationId 申请id
     * @return 结果
     */

    @ApiOperation("申请通过后，插入一条动物记录")
    @PostMapping("insertAnimal")
    public Result<String> insertAnimal(Integer applicationId){
        //首先更改申请状态的字段
        animalService.acceptApplication(applicationId);
        AnimalRecord animalRecord = animalService.getAnimalByApplicationId(applicationId);
        Integer animalRecordId = animalRecord.getId();
        boolean isSuccess = animalService.register(animalRecord)==1;
        //读取AnimalRecord(动物记录)对象中的动物图片的list，将其插入animalImgList表中
        List<AnimalImg> animalImgList = animalRecord.getAnimalImgList();
        for(AnimalImg animalImg:animalImgList){
            animalImg.setAnimalRecordId(animalRecordId);
            animalImgService.addImg(animalImg);
        }
        if(isSuccess){
            return ResultUtils.success("添加动物信息成功");
        }
        return ResultUtils.fail("添加动物信息失败");
    }

    /**
     * 申请通过后，修改动物信息
     * @param applicationId 申请id
     * @return 结果
     */

    @ApiOperation("更新动物记录")
    @PostMapping("updateAnimal")
    public Result<String> updateAnimal(Integer applicationId){
        animalService.acceptApplication(applicationId);
        AnimalRecord animalRecord = animalService.getAnimalByApplicationId(applicationId);
        boolean isSuccess = animalService.update(animalRecord)==1;
        if(isSuccess){
            return ResultUtils.success("修改动物信息成功");
        }
        return ResultUtils.fail("修改动物信息失败");
    }

    /**
     * 拒绝申请
     * @param applicationId 申请id
     * @return 提示消息
     */

    @ApiOperation("拒绝一个申请")
    @PostMapping("denyApplication")
    public Result<String> denyApplication(Integer applicationId){
        animalService.denyApplication(applicationId);
        return ResultUtils.success("该申请已被成功拒绝");
    }

    /**
     * 条件查询动物信息
     * @param current 当前页码
     * @param limit 每页的页码数
     * @param animalQuery 条件查询Vo类：包含动物最后出现的地址和动物的状态
     * @return boList 包含该页面所需动物信息的bo类的List
     */

    @ApiOperation("通过多种条件查询动物")
    @PostMapping("queryAnimal")
    public Result<PageConditionalQueryAnimalsBo> queryAnimal(Long current, Long limit, @RequestBody AnimalQuery animalQuery){
        List<ConditionalQueryAnimalsBo> boList = new ArrayList<>();
        //创建分页对象
        Page<AnimalRecord> page = new Page<>(current,limit);
        //条件查询对象
        QueryWrapper<AnimalRecord> wrapper = new QueryWrapper<>();
        //创建Bo对象
        PageConditionalQueryAnimalsBo pbo = new PageConditionalQueryAnimalsBo();
        //使用动态sql完成组合条件查询
        String addressIndex = animalQuery.getAddressFirstIndex();
        int status = animalQuery.getStatus();

        wrapper.eq("address_first_index",addressIndex);
        wrapper.eq("status",status);

        //根据最新的修改时间时间进行排序
        wrapper.orderByDesc("update_time");
        //调用方法实现分页的条件查询
        animalService.page(page,wrapper);
        //获取当前页的记录
        List<AnimalRecord> recordList = page.getRecords();
        //返回总记录数
        Long totalRecordsNum = page.getTotal();

        //为了返回每个动物的数据，首先遍历结果集
        for(int i=0;i<recordList.size();i++){
            //创建bo对象
            ConditionalQueryAnimalsBo bo = new ConditionalQueryAnimalsBo();
            //获取动物id
            Integer animalId = recordList.get(i).getId();
            bo.setAnimalNickname(recordList.get(i).getAnimalNickname());
            bo.setAnimalType(recordList.get(i).getAnimalType());
            bo.setLastAddress(recordList.get(i).getLastAddress());
            //只需要显示一张动物图片，所以只需要取每个动物图片List里的第一张图片
            bo.setImgUrl(animalImgService.queryAnimalImgListByAnimalId(animalId).get(0).getPath());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            //规范化时间
            String formatCreateTime = recordList.get(i).getCreateTime().format(formatter);
            bo.setUpdateTime(formatCreateTime);
            boList.add(i,bo);
        }
        pbo.setAnimalList(boList);
        pbo.setTotalRecordsNum(totalRecordsNum);

        return ResultUtils.success(pbo);
    }


    @ApiOperation("用户申请领养动物")
    @PostMapping("animalAdoption")
    public Result<String> applyForAnimalAdoption(Integer animalId){
        animalService.animalAdoption(animalId);
        return ResultUtils.success("申请领养成功！");
    }

    /**
     * 根据动物id删除动物信息
     * @param id 动物id
     * @return 是否删除成功
     */

    @ApiOperation("通过动物id删除动物")
    @DeleteMapping({"{id}"})
    public Result<String> deleteAnimalRecord(@PathVariable int id){
        boolean res = animalService.removeById(id);
        if(res){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }

    /**
     * 查看一名用户的所有申请
     * @param userId 用户id
     * @return 申请列表
     */

    @ApiOperation("通过用户id查询该用户的所有申请")
    @GetMapping("queryApplicationList")
    public Result<List<ApplicationListBo>> queryApplicationList(String userId){
        List<ApplicationListBo> boList = new ArrayList<>();
        List<Application> applicationList = animalService.queryApplicationListByUserId(userId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for(int i=0;i<applicationList.size();i++){
            Application application = applicationList.get(i);
            ApplicationListBo bo = new ApplicationListBo();
            bo.setApplicationId(application.getId());
            bo.setImgUrl(animalService.getAnimalByApplicationId(application.getId()).getAnimalImgList().get(0).getPath());
            bo.setStatus(application.getStatus());
            bo.setAnimalNickname(animalService.getAnimalByApplicationId(application.getId()).getAnimalNickname());
            bo.setUpdateTime(application.getUpdateTime().format(formatter));
            boList.add(i,bo);
        }
    return ResultUtils.success(boList);
    }


}
