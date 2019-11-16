package com.revanwang.xc.api.cms;

import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.domain.cms.request.QueryTemplateRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms模板接口管理", description = "cms模板管理接口，提供模板的增、删、改、查")
public interface ICmsTemplateAPI {

    @ApiOperation("模板列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从1开始", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int"),
    })
    QueryResponseResult findCmsTemplateList(int page, int size, QueryTemplateRequest templateRequest);


}
