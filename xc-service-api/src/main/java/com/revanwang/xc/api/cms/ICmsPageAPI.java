package com.revanwang.xc.api.cms;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "cms页面查询接口管理", description = "cms页面管理接口，提供页面的增、删、改、查")
public interface ICmsPageAPI {

    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码从1开始", required = true, paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "path", dataType = "int"),
    })
    QueryResponseResult findCmsList(int page, int size, QueryPageRequest queryPageRequest);


    @ApiOperation("查询cms站点")
    QueryResponseResult queryCmsSiteList();


    @ApiOperation("查询cms模板")
    QueryResponseResult queryCmsTemplateList();

    @ApiOperation("新增cms页面")
    QueryResponseResult cmsPageAdd(CmsPage cmsPage);


    @ApiOperation("删除cms页面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "删除id", required = true, paramType = "path", dataType = "string")
    })
    QueryResponseResult cmsPageDelete(String id);



}
