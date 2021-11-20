package com.HexTechGDUT.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * animal和animalImg都是动物相关,不需要设置多个接口
 * @author HexTechGDUT
 */
@Api("动物")
@CrossOrigin
@RestController
@RequestMapping(value = "/animal")
public class AnimalController {
}
