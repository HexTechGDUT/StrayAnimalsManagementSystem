package com.HexTechGDUT.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    String uploadAnimalPicture(MultipartFile file);
}
