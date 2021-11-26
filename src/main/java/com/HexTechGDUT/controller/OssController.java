package com.HexTechGDUT.controller;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.service.OssService;
import com.HexTechGDUT.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileoss")
@CrossOrigin
public class OssController {
    //注入Service
    @Autowired
    private OssService ossService;

    @PostMapping
    public Result<String> uploadOssFile(MultipartFile file){
        String url = ossService.uploadAnimalPicture(file);
        return ResultUtils.success(url);
    }

}
