package com.revanwang.xc.framework.exception;

import com.revanwang.xc.framework.model.response.IResultCode;
import lombok.Getter;

/**
 * 自定义异常类
 */
@Getter
public class RevanException extends RuntimeException {
    private IResultCode resultCode;

    public RevanException(IResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
