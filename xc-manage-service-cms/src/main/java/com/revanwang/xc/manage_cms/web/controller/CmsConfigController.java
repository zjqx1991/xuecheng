package com.revanwang.xc.manage_cms.web.controller;

import com.revanwang.xc.api.cms.ICmsConfigAPI;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.manage_cms.service.ICmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cms/config")
public class CmsConfigController implements ICmsConfigAPI {

    @Autowired
    private ICmsConfigService cmsConfigService;

    @Override
    @GetMapping("/list")
    public QueryResponseResult findCmsConfigList() {
        return cmsConfigService.findCmsConfigList();
    }

    @Override
    @GetMapping("/get/{id}")
    public QueryResponseResult findCmsConfigById(@PathVariable("id") String id) {
        return cmsConfigService.findCmsConfigById(id);
    }
}
