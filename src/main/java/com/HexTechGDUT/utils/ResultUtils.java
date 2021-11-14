package com.HexTechGDUT.utils;

import com.HexTechGDUT.result.Result;
import com.HexTechGDUT.result.ResultType;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * 生成返回给前端的对象的工具类
 * @author HexTechGDUT
 */
public class ResultUtils implements Serializable {

    public static final long serialVersionUID = 1111;

    public static void sendResult(HttpServletResponse response, Result result){
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

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
