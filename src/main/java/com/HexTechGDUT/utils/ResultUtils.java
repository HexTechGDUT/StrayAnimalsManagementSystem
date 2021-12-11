package com.HexTechGDUT.utils;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.result.ResultType;
import java.io.Serializable;

/**
 * 生成返回给前端的对象的工具类
 * @author HexTechGDUT
 */
public class ResultUtils implements Serializable {

    public static final long serialVersionUID = 1111;

    /**
     * 返回操作成功的结果;
     * @param e 附带的对象element
     * @return Result
     */
    public static <E> Result<E> success(E e){
        return new Result<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getInfo(), e);
    }

    /**
     * 返回操作成功的结果;
     * @param e 附带的对象element
     * @param info 信息
     * @return Result
     */
    public static <E> Result<E> successWithInfo(E e, String info){
        return new Result<>(ResultType.SUCCESS.getCode(), info, e);
    }

    /**
     * 返回操作失败的结果;
     * @param e 附带的对象element
     * @return Result
     */
    public static <E> Result<E> fail(E e){
        return new Result<>(ResultType.FAIL.getCode(), ResultType.FAIL.getInfo(), e);
    }

    /**
     * 返回操作失败的结果;
     * @param e 附带的对象element
     * @param info 信息
     * @return Result
     */
    public static <E> Result<E> failWithInfo(E e, String info){
        return new Result<>(ResultType.FAIL.getCode(), info, e);
    }
}
