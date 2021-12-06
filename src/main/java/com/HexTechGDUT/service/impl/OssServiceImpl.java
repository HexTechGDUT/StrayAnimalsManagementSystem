package com.HexTechGDUT.service.impl;

import com.HexTechGDUT.service.OssService;
import com.HexTechGDUT.utils.ConstantPropertiesUtils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    @Override
    public String uploadAnimalPicture(MultipartFile file) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。
        String endpoint = ConstantPropertiesUtils.END_POINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = ConstantPropertiesUtils.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        try{
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 获取文件名称
            String fileName = file.getOriginalFilename();
            // 由于不同用户上传头像时可能上传相同文件名的图片，而在oss中相同的文件名会导致覆盖。故使用uuid随机生成文件名来保证每个用户头像名的唯一性。
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            fileName = uuid+fileName;
            // 将文件按照日期进行分类(使用Maven中引用的工具类joda-time)
            String dataPath = new DateTime().toString("yyyy/MM/dd");
            fileName = dataPath+"/"+fileName;
            // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
            InputStream inputStream = file.getInputStream();
            // 依次填写Bucket名称（例如examplebucket）和Object完整路径（例如exampledir/exampleobject.txt）。Object完整路径中不能包含Bucket名称。
            ossClient.putObject(bucketName,fileName, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            // 根据oss中url的格式，拼接url
            String url = "https://"+bucketName+"."+endpoint+"/"+fileName;
            return url;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
