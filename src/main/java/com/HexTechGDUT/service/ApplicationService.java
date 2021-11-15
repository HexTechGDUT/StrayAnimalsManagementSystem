package com.HexTechGDUT.service;

import com.HexTechGDUT.po.application.Application;
import com.HexTechGDUT.po.application.AnswerType;

/**
 * 申请服务
 * @author HexTechGDUT
 */
public interface ApplicationService {

    /**
     * 添加申请(领养或弃养或别的...)
     * @param application 申请信息
     * @return 处理结果
     */
     AnswerType apply(Application application);

    /**
     * 取消申请
     * 只有申请的状态在未处理时才能取消成功
     * @param id 申请的id
     * @return 是否取消成功
     */
    boolean cancel(String id);

}
