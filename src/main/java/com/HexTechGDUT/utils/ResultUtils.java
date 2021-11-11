package com.HexTechGDUT.utils;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.result.ResultType;

/**
 * 生成返回给前端的对象的工具类
 * @author HexTechGDUT
 */
public class ResultUtils {

    /**
     * 返回操作成功的结果
     * @param p 附带的对象
     * @return Result
     */
    public static <P> Result<P> success(P p){
        return new Result<>(ResultType.SUCCESS.getCode(), ResultType.SUCCESS.getInfo(), p);
    }

    /**
     * 返回操作成功的结果
     * @param p 附带的对象
     * @param info 信息
     * @return Result
     */
    public static <P> Result<P> successWithInfo(P p, String info){
        return new Result<>(ResultType.SUCCESS.getCode(), info, p);
    }

    /**
     * 返回操作失败的结果
     * @param p 附带的对象
     * @return Result
     */
    public static <P> Result<P> fail(P p){
        return new Result<>(ResultType.FAIL.getCode(), ResultType.FAIL.getInfo(), p);
    }

    /**
     * 返回操作失败的结果
     * @param p 附带的对象
     * @param info 信息
     * @return Result
     */
    public static <P> Result<P> failWithInfo(P p, String info){
        return new Result<>(ResultType.FAIL.getCode(), info, p);
    }

    /**
     * 返回没有操作权限的结果
     * @param p 附带的对象
     * @return Result
     */
    public static <P> Result<P> noPermit(P p){
        return new Result<>(ResultType.NO_PERMIT.getCode(), ResultType.NO_PERMIT.getInfo(), p);
    }

    /**
     * 返回没有操作权限的结果
     * @param p 附带的对象
     * @param info 信息
     * @return Result
     */
    public static <P> Result<P> noPermitWithInfo(P p, String info){
        return new Result<>(ResultType.NO_PERMIT.getCode(), info, p);
    }
}
