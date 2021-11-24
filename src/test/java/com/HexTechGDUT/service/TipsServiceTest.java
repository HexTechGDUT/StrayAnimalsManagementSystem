package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.Tips;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
public class TipsServiceTest {

    @Resource
    TipsService tipsService;

    @Test
    @Transactional
    @Rollback
    public void insertTest(){
        Tips tips = new Tips();
        tips.setId(1);
        tips.setTitle("title1");
        tips.setContent("content1");
        System.out.println(tipsService.insert(tips));
    }

    @Test
    @Transactional
    @Rollback
    public void updateTest(){
        Tips tips = new Tips();
        tips.setId(1);
        tips.setTitle("title2");
        System.out.println(tipsService.update(tips));
    }

    @Test
    @Transactional
    @Rollback
    public void deleteTest(){
        System.out.println(tipsService.delete(1));
    }

    @Test
    public void queryAllTipsTest(){
        System.out.println(tipsService.queryAllTips());
    }

    @Test
    public void queryTipsByIdTest(){
        System.out.println(tipsService.queryTipsById(1));
    }
}
