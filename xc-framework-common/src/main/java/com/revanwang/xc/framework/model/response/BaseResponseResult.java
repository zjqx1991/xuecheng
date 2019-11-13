package com.revanwang.xc.framework.model.response;

import lombok.Data;

@Data
public class BaseResponseResult implements IBaseResponse {
    //操作是否成功
    private boolean success = SUCCESS;

    //操作代码
    private int code = SUCCESS_CODE;

    //提示信息
    private String message;

    public BaseResponseResult(IResultCode resultCode){
        this.success = resultCode.success();
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

    public static BaseResponseResult SUCCESS(){
        return new BaseResponseResult(CommonCode.SUCCESS);
    }
    public static BaseResponseResult FAIL(){
        return new BaseResponseResult(CommonCode.FAIL);
    }
}
