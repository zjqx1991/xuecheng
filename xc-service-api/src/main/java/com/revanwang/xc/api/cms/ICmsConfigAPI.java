package com.revanwang.xc.api.cms;

import com.revanwang.xc.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms配置接口管理", description = "cms配置管理接口，提供配置的增、删、改、查")
public interface ICmsConfigAPI {

    @ApiOperation("配置列表")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "page", value = "页码从1开始", required = true, paramType = "path", dataType = "int"),
//            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int"),
//    })
    QueryResponseResult findCmsConfigList();


    @ApiOperation("获取配置对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "模板id", required = true, paramType = "path", dataType = "string"),
    })
    QueryResponseResult findCmsConfigById(String id);


}
