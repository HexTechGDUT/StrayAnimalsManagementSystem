package com.HexTechGDUT.service;

import com.HexTechGDUT.entity.po.Application;
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
     * 添加申请(领养或弃养或别的...);
     * @param application 申请信息
     * @return 处理结果
     */
     int apply(Application application);

    /**
     * 用户修改自己的申请;
     * 只有申请的状态在未处理时才能取消成功;
     * @param application application
     * @return 是否修改成功
     */
     int update(Application application);

    /**
     * 管理员处理申请;
     * @param application 处理前的申请
     * @return 处理后的申请
     */
     int process(Application application);

    /**
     * 取消申请;
     * 只有申请的状态在未处理时才能取消成功;
     * 设置申请的状态为3
     * @param id 申请的id
     * @return 是否取消成功
     */
    int cancel(int id);

    /**
     * 通过id查询一个申请;
     * @param id id
     * @return application
     */
    Application queryApplicationById(int id);

    /**
     * 查询有关某个动物的全部申请;
     * @param animalId animalRecordId
     * @return application
     */
    List<Application> queryApplicationByAnimalId(int animalId);

    /**
     * 查询所有状态为(...)的申请;
     * @param status status
     * @return application
     */
    List<Application> queryApplicationByStatus(int status);

    /**
     * 查询某个用户的全部申请;
     * @param userId userId
     * @return application
     */
    List<Application> queryApplicationByUserId(String userId);

}
