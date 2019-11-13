package com.revanwang.xc.manage_cms.web.controller;

import com.revanwang.xc.api.cms.ICmsPageAPI;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements ICmsPageAPI {

    @Autowired
    private ICmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return this.cmsPageService.findList(page, size, queryPageRequest);
    }
}
