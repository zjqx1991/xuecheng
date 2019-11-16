package com.revanwang.xc.manage_cms.web.controller;

import com.revanwang.xc.api.cms.ICmsTemplateAPI;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.domain.cms.request.QueryTemplateRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.service.ICmsTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/template")
public class CmsTemplateController implements ICmsTemplateAPI {

    @Autowired
    private ICmsTemplateService cmsTemplateService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findCmsTemplateList(@PathVariable("page") int page, @PathVariable("size") int size, QueryTemplateRequest templateRequest) {
        return this.cmsTemplateService.findCmsTemplateList(page, size, templateRequest);
    }
}
