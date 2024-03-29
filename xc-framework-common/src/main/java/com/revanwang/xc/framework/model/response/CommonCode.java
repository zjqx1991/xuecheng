package com.revanwang.xc.framework.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: mrt.
 * @Description:
 * @Date:Created in 2018/1/24 18:33.
 * @Modified By:
 */

@Getter
public enum CommonCode implements IResultCode{

    SUCCESS(true,0,"操作成功！"),
    FAIL(false,11111,"操作失败！"),
    UNAUTHENTICATED(false,10001,"此操作需要登陆系统！"),
    UNAUTHORISE(false,10002,"权限不足，无权操作！"),
    SERVER_ERROR(false,99999,"抱歉，系统繁忙，请稍后重试！"),
    INVALIDPARAM(false,99999,"抱歉，系统繁忙，请稍后重试！"),

    //CMS
    CMS_ADDPAGE_EXISTS(false, 1, "添加页面已存在"),
    CMS_NOT_FOUND(false, 2, "页面不已存"),

    //CMS_template
    CMS_TEMPLATE_PATH_NOT_FOUND(false, 1, "模板文件路径不存在"),
    CMS_TEMPLATE_GRIDFS_SAVE_FAIL(false, 2, "模板文件存储GridFS失败"),
    CMS_TEMPLATE_DELETE_PARAM_FAIL(false, 3, "模板文件删除id错误"),


    //CMS_Config
    CMS_CONFIG_NOT_FOUND(false, 1, "内容不已存"),
    ;

    //    private static ImmutableMap<Integer, CommonCode> codes ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
