package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 申请信息（申请领养或弃养）
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Application {

    /**
     * 申请id
     */
    private String applyId;

    /**
     * 申请类型
     */
    private ApplicationType type;

    /**
     * 简要描述
     */
    private String briefInfo;

    /**
     * 相关动物id
     */
    private String animalId;

    /**
     * 申请用户id
     */
    private String uid;

    /**
     * 申请时间
     */
    private LocalDateTime applyTime;

    /**
     * 申请状态
     */
    private ApplicationStatus status;

    /**
     * 处理结果的id
     */
    private String returnId;

}
