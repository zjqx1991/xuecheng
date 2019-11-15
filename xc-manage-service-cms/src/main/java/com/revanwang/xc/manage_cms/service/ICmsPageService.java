package com.revanwang.xc.manage_cms.service;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.QueryResponseResult;

public interface ICmsPageService {
    /**
     * 查询 CMS 页面信息
     * @param page 页数
     * @param size 大小
     * @param queryPageRequest 查询条件
     * @return
     */
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    /**
     * 查询 CMS 站点
     */
    QueryResponseResult querySiteList();

    /**
     * 查询 CMS 模板
     */
    QueryResponseResult queryCmsTemplateList();


    /**
     * 添加 CMS 页面
     */
    QueryResponseResult cmsPageAdd(CmsPage cmsPage);

    /**
     * 删除 CMS
     * @param id CMS的id
     * @return
     */
    QueryResponseResult cmsPageDelete(String id);
}
