package com.revanwang.xc.framework.domain.cms.request;

import com.revanwang.xc.framework.model.request.BaseRequestData;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QueryTemplateRequest extends BaseRequestData {
    //接收页面查询的查询条件
    //站点id
    //站点id
    @ApiModelProperty("模板别名/id/站点id")
    private String param;
}