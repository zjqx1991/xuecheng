package com.revanwang.xc.manage_cms.service.impl;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.CmsSite;
import com.revanwang.xc.framework.domain.cms.CmsTemplate;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.framework.model.response.QueryResult;
import com.revanwang.xc.manage_cms.dao.ICmsPageRepository;
import com.revanwang.xc.manage_cms.dao.ICmsSiteRepository;
import com.revanwang.xc.manage_cms.dao.ICmsTemplateRepository;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsPageServiceImpl implements ICmsPageService {

    @Autowired
    private ICmsPageRepository cmsPageRepository;
    @Autowired
    private ICmsSiteRepository cmsSiteRepository;
    @Autowired
    private ICmsTemplateRepository cmsTemplateRepository;

    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryCondition) {
        if(queryCondition == null){
            queryCondition = new QueryPageRequest();
        }

        //1.设置页码查询
        if (page < 1) {
            page = 1;
        }
        page = page - 1;
        if (size < 10) {
            size = 10;
        }
        Pageable pageable = PageRequest.of(page, size);

        //2.设置条件查询
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        //3.添加查询
        CmsPage cmsPage = new CmsPage();
        if (queryCondition != null) {
            //3.1 站点查询
            String siteId = queryCondition.getSiteId();
            if (StringUtils.isNotBlank(siteId)) {
                cmsPage.setSiteId(siteId);
            }
            //3.2 页面查询
            String templateId = queryCondition.getTemplateId();
            if (StringUtils.isNotBlank(templateId)) {
                cmsPage.setTemplateId(templateId);
            }

            //3.3 页面别名
            String pageAliasName = queryCondition.getPageAliase();
            if (StringUtils.isNotBlank(pageAliasName)) {
                cmsPage.setPageAliase(pageAliasName);
            }
        }

        //4.条件查询
        Example<CmsPage> example = Example.of(cmsPage, matcher);
//        Page<CmsPage> pages = this.cmsPageRepository.findAll(example, pageable);
        Page<CmsPage> pages = this.cmsPageRepository.findAll(pageable);

        QueryResult result = new QueryResult();
        result.setList(pages.getContent());
        result.setTotal(pages.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    @Override
    public QueryResponseResult querySiteList() {
        List<CmsSite> cmsSites = this.cmsSiteRepository.findAll();
        QueryResult<CmsSite> result = new QueryResult<>();
        result.setList(cmsSites);
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    @Override
    public QueryResponseResult queryCmsTemplateList() {
        List<CmsTemplate> cmsTemplates = this.cmsTemplateRepository.findAll();
        QueryResult<CmsTemplate> result = new QueryResult<>();
        result.setList(cmsTemplates);
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }
}
