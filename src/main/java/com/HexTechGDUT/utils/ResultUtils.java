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

    /**
     * 返回没有操作权限的结果;
     * @param e 附带的对象element
     * @return Result
     */
    public static <E> Result<E> noPermit(E e){
        return new Result<>(ResultType.NO_PERMIT.getCode(), ResultType.NO_PERMIT.getInfo(), e);
    }

    /**
     * 返回没有操作权限的结果;
     * @param e 附带的对象element
     * @param info 信息
     * @return Result
     */
    public static <E> Result<E> noPermitWithInfo(E e, String info){
        return new Result<>(ResultType.NO_PERMIT.getCode(), info, e);
    }
}
