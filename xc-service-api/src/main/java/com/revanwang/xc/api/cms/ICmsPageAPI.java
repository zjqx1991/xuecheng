package com.revanwang.xc.api.cms;

import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


public interface ICmsPageAPI {


    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);
}
