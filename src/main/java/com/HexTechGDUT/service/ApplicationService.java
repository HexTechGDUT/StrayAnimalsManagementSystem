package com.HexTechGDUT.service;

import com.HexTechGDUT.po.application.Application;
import com.HexTechGDUT.po.application.ResultType;

/**
 * 申请服务
 * @author HexTechGDUT
 */
public interface ApplicationService {

    /**
     * 申请领养或弃养
     * @param application 申请信息
     * @return 处理结果
     */
     ResultType apply(Application application);

}
