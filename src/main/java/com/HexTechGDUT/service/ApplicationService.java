package com.HexTechGDUT.service;

import com.HexTechGDUT.po.Application;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 申请服务
 * @author HexTechGDUT
 */
@Repository
public interface ApplicationService extends IService<Application> {

    /**
     * 添加申请(领养或弃养或别的...)
     * @param application 申请信息
     * @return 处理结果
     */
     boolean apply(Application application);

    /**
     * 处理申请
     * @param application 处理前的申请
     * @return 处理后的申请
     */
     boolean process(Application application);

    /**
     * 取消申请
     * 只有申请的状态在未处理时才能取消成功
     * @param id 申请的id
     * @return 是否取消成功
     */
    boolean cancel(String id);

    /**
     * 通过id查询一个申请
     * @param id id
     * @return application
     */
    Application queryApplicationById(int id);

    /**
     * 查询有关某个动物的全部申请
     * @param animalId animalRecordId
     * @return application
     */
    List<Application> queryApplicationByAnimalId(String animalId);

    /**
     * 查询所有状态为’未处理‘的申请
     * @param status status
     * @return application
     */
    List<Application> queryApplicationByStatus(int status);

    /**
     * 查询某个用户的全部申请
     * @param userId userId
     * @return application
     */
    List<Application> queryApplicationByUserId(String userId);

}
