package com.HexTechGDUT.controller;

import com.HexTechGDUT.entity.po.AnimalImg;
import com.HexTechGDUT.entity.po.AnimalRecord;
import com.HexTechGDUT.entity.vo.AnimalQuery;
import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.service.AnimalImgService;
import com.HexTechGDUT.service.AnimalService;
import com.HexTechGDUT.utils.ResultUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @GetMapping("queryAll")
    public Result<List<AnimalRecord>> queryAllAnimals(){
        List<AnimalRecord> recordList = animalService.list(null);
        //为了查询所查动物对应的图片，首先遍历结果集
        for(AnimalRecord record:recordList){
            //取出每一个动物信息对象的id
            Integer id = record.getId();
            //调用根据动物id查询对应图片的方法，同样用list存储
            List<AnimalImg> animalImgList = animalImgService.queryAnimalImgListByAnimalId(id);
            //将图片的list存入record中
            record.setAnimalImgList(animalImgList);
        }
        return ResultUtils.success(recordList);
    }

    /**
     * 添加一个动物
     * @param animalRecord 动物信息类
     * @return 结果
     */
    @PostMapping("insertAnimal")
    public Result<String> insertAnimal(@RequestBody AnimalRecord animalRecord){
        boolean isSuccess = animalService.register(animalRecord)==1;
        int animalRecordId = animalRecord.getId();
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
     * 修改动物信息
     * @param animalRecord 动物信息实体类
     * @return 结果
     */
    @PostMapping("updateAnimal")
    public Result<String> updateAnimal(@RequestBody AnimalRecord animalRecord){
        boolean isSuccess = animalService.update(animalRecord)==1;
        if(isSuccess){
            return ResultUtils.success("修改动物信息成功");
        }
        return ResultUtils.fail("修改动物信息失败");
    }

    /**
     * 条件查询动物信息
     * @param animalQuery 条件查询Vo类：包含动物昵称、最后出现的地点、动物中列、状态、记录类型5个属性
     * @return animalRecordList 包含动物信息的List
     */
    @PostMapping("queryAnimal")
    public Result<List<AnimalRecord>> queryAnimal(@RequestBody AnimalQuery animalQuery){
        QueryWrapper<AnimalRecord> wrapper = new QueryWrapper<>();
        //使用动态sql完成组合条件查询
        String animalNickname = animalQuery.getAnimalNickname();
        String lastAddress = animalQuery.getLastAddress();
        String animalType = animalQuery.getAnimalType();
        Integer status = animalQuery.getStatus();
        Integer recordType = animalQuery.getRecordType();
        if(StringUtils.isNotBlank(animalNickname)){
            wrapper.like("animal_nickname",animalNickname);
        }
        if(StringUtils.isNotBlank(lastAddress)){
            wrapper.like("last_address",lastAddress);
        }
        if(StringUtils.isNotBlank(animalType)){
            wrapper.eq("animal_type",animalType);
        }
        if(org.springframework.util.StringUtils.isEmpty(status)){
            wrapper.eq("status",status);
        }
        if(org.springframework.util.StringUtils.isEmpty(recordType)){
            wrapper.eq("record_type",recordType);
        }
        List<AnimalRecord> recordList = animalService.list(wrapper);
        //为了查询所查动物对应的图片，首先遍历结果集
        for(AnimalRecord record:recordList){
            //取出每一个动物信息对象的id
            Integer id = record.getId();
            //调用根据动物id查询对应图片的方法，同样用list存储
            List<AnimalImg> animalImgList = animalImgService.queryAnimalImgListByAnimalId(id);
            //将图片的list存入record中
            record.setAnimalImgList(animalImgList);
        }
        return ResultUtils.success(recordList);
    }

    /**
     * 根据动物id删除动物信息
     * @param id 动物id
     * @return 是否删除成功
     */
    @DeleteMapping({"{id}"})
    public Result<String> deleteAnimalRecord(@PathVariable int id){
        boolean res = animalService.removeById(id);
        if(res){
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.fail("删除失败");
    }
}
