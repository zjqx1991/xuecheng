package com.revanwang.xc.manage_cms.service.impl;

import com.revanwang.xc.framework.domain.cms.CmsPage;
import com.revanwang.xc.framework.domain.cms.request.QueryPageRequest;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.framework.model.response.QueryResult;
import com.revanwang.xc.manage_cms.dao.ICmsPageRepository;
import com.revanwang.xc.manage_cms.service.ICmsPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CmsPageServiceImpl implements ICmsPageService {

    @Autowired
    private ICmsPageRepository cmsPageRepository;

    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        if (page < 1) {
            page = 1;
        }
        page = page - 1;

        if (size < 10) {
            size = 10;
        }

        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> pages = this.cmsPageRepository.findAll(pageable);

        QueryResult result = new QueryResult();
        result.setList(pages.getContent());
        result.setTotal(pages.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }
}
