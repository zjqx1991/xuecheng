package com.revanwang.xc.manage_cms.service;


import com.revanwang.xc.framework.domain.cms.CmsTemplate;
import com.revanwang.xc.framework.domain.cms.request.QueryTemplateRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;

public interface ICmsTemplateService {
    /**
     * 获取模板列表
     * @param page
     * @param size
     * @param templateRequest
     * @return
     */
    QueryResponseResult findCmsTemplateList(int page, int size, QueryTemplateRequest templateRequest);

    /**
     * 模板新增
     * @param template
     * @return
     */
    QueryResponseResult cmsTemplateAdd(CmsTemplate template);

    /**
     * 删除模板
     * @param id
     * @return
     */
    QueryResponseResult cmsTemplateDelete(String id);
}
