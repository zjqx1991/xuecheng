package com.revanwang.xc.manage_cms.dao;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICmsPageRepository extends MongoRepository<CmsPage, String> {


    /**
     * 查询CMS
     * @param pageName  cms页面名称
     * @param siteId    站点id
     * @param pageWebPath   页面路径
     * @return
     */
    CmsPage findByPageNameAndSiteIdAndPageWebPath(String pageName, String siteId, String pageWebPath);
}
