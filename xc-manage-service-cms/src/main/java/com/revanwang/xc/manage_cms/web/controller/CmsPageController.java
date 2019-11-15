package com.revanwang.xc.manage_cms.web.controller;

import com.revanwang.xc.api.cms.ICmsPageAPI;
import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cms/page")
public class CmsPageController implements ICmsPageAPI {

    @Autowired
    private ICmsPageService cmsPageService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findCmsList(@PathVariable("page") int page, @PathVariable("size") int size, QueryPageRequest queryPageRequest) {
        return this.cmsPageService.findList(page, size, queryPageRequest);
    }

    @Override
    @GetMapping("/by/id/{id}")
    public QueryResponseResult queryCmsById(@PathVariable("id") String id) {
        return this.cmsPageService.queryCmsById(id);
    }

    @Override
    @GetMapping("/site")
    public QueryResponseResult queryCmsSiteList() {
        return this.cmsPageService.querySiteList();
    }

    @Override
    @GetMapping("/template")
    public QueryResponseResult queryCmsTemplateList() {
        return this.cmsPageService.queryCmsTemplateList();
    }


    @Override
    @GetMapping("/add")
    public QueryResponseResult cmsPageAdd(CmsPage cmsPage) {
        return this.cmsPageService.cmsPageAdd(cmsPage);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public QueryResponseResult cmsPageDelete(@PathVariable("id") String id) {
        return this.cmsPageService.cmsPageDelete(id);
    }
}
