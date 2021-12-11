package com.HexTechGDUT.exception;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.utils.ResultUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * @author HexTechGDUT
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        String brief = e.getMessage();
        String details = e.toString();
        if (brief == null || "".equals(brief)) {
            return ResultUtils.fail(details);
        }
        return ResultUtils.failWithInfo(brief, details);
    }
}
