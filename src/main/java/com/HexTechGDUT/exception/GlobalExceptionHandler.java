package com.HexTechGDUT.exception;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.utils.ResultUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理器
 * @author HexTechGDUT
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || "".equals(msg)) {
            msg = "服务器出错";
        }
        return ResultUtils.fail(msg);
    }
}
