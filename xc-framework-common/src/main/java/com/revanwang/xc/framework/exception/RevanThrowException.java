package com.revanwang.xc.framework.exception;

import com.revanwang.xc.framework.model.response.IResultCode;

/**
 * 异常抛出类
 */
public class RevanThrowException {

    /**
     * 抛出自定义异常
     */
    public static void throwException(IResultCode resultCode) {
        throw new RevanException(resultCode);
    }

}
