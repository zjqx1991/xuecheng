package com.revanwang.xc.framework.exception;

import com.google.common.collect.ImmutableMap;
import com.revanwang.xc.framework.model.response.BaseResponseResult;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.IResultCode;
import org.slf4j.Logger;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一拦击异常类
 */
@ControllerAdvice
public class RevanExceptionCatch {

    /**
     *  使用Exceptions存放异常类和错误代码的映射，
     *  ImmutableMap的特点一旦创建不可改变，并且线程安全
     */
    private static ImmutableMap<Class <? extends Throwable>, IResultCode> EXCEPTIONS;

    //使用builder来构建一个异常类型和错误代码的异常
    protected static ImmutableMap.Builder<Class<? extends  Throwable>, IResultCode> builder = ImmutableMap.builder();

    static {
        //在这里加入一些基础异常类型判断
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALIDPARAM);
    }

    /**
     * 处理自定义异常类
     */
    @ExceptionHandler(RevanException.class)
    @ResponseBody
    public BaseResponseResult exceptionCatch(RevanException e) {

        IResultCode resultCode = e.getResultCode();
        return new BaseResponseResult(resultCode);
    }

    /**
     * 处理系统异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public BaseResponseResult systemException(Exception e) {
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();
        }
        final IResultCode resultCode = EXCEPTIONS.get(e.getClass());
        final BaseResponseResult responseResult;
        if (resultCode != null) {
            responseResult = new BaseResponseResult(resultCode);
        }
        else {
            responseResult = new BaseResponseResult(CommonCode.SERVER_ERROR);
        }
        return responseResult;
    }
}
