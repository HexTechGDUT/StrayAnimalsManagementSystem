package com.HexTechGDUT.po.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 申请的处理结果
 * @author HexTechGDUT
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResultInfo {

    /**
     * 处理id
     */
    private String returnId;

    /**
     * 处理结果
     */
    private ResultType result;

    /**
     * 具体处理结果和原因
     */
    private String details;

    /**
     * 处理人id
     * 一般为管理员
     */
    private String uid;

    /**
     * 处理时间
     */
    private LocalDateTime returnTime;
}
