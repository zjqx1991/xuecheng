package com.revanwang.xc.manage_cms.service.impl;


import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.CmsTemplate;
import com.revanwang.xc.framework.domain.cms.request.QueryTemplateRequest;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.framework.model.response.QueryResult;
import com.revanwang.xc.manage_cms.dao.ICmsTemplateRepository;
import com.revanwang.xc.manage_cms.service.ICmsTemplateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmsTemplateServiceImpl implements ICmsTemplateService {

    @Autowired
    private ICmsTemplateRepository templateRepository;

    @Override
    public QueryResponseResult findCmsTemplateList(int page, int size, QueryTemplateRequest templateRequest) {
        if (templateRequest == null) {
            templateRequest = new QueryTemplateRequest();
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
                .withMatcher("templateName", ExampleMatcher.GenericPropertyMatchers.contains());
//                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.contains())
//                .withMatcher("siteId", ExampleMatcher.GenericPropertyMatchers.contains())
        //3.添加查询
        CmsTemplate template = new CmsTemplate();
        if (templateRequest != null) {
            //3.1 站点查询
            String templateParam = templateRequest.getParam();
            if (StringUtils.isNotBlank(templateParam)) {
//                template.setId(templateParam);
//                template.setSiteId(templateParam);
                template.setTemplateName(templateParam);
            }
        }
        //4.条件查询
        Example<CmsTemplate> example = Example.of(template, matcher);
        Page<CmsTemplate> templatePages = this.templateRepository.findAll(example, pageable);
        QueryResult<List<CmsTemplate>> result = new QueryResult<>();
        result.setData(templatePages.getContent());
        result.setTotal(templatePages.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }
}
