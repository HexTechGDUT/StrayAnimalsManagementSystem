package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.AnimalRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class AnimalServiceTest {

    @Resource
    AnimalService animalService;

    @Test
    public void jsonToRecordTest(){
        System.out.println(animalService.getAnimalByApplicationId(10011));
    }
}
