package com.revanwang.xc.manage_cms.service.impl;


import com.revanwang.xc.framework.domain.cms.CmsConfig;
import com.revanwang.xc.framework.exception.RevanThrowException;
import com.revanwang.xc.framework.model.response.CommonCode;
import com.revanwang.xc.framework.model.response.QueryResponseResult;
import com.revanwang.xc.framework.model.response.QueryResult;
import com.revanwang.xc.manage_cms.dao.ICmsConfigRepository;
import com.revanwang.xc.manage_cms.service.ICmsConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CmsConfigServiceImpl implements ICmsConfigService {

    @Autowired
    private ICmsConfigRepository configRepository;

    @Override
    public QueryResponseResult findCmsConfigList() {
        List<CmsConfig> configList = this.configRepository.findAll();
        if (configList == null) {
            RevanThrowException.throwException(CommonCode.CMS_CONFIG_NOT_FOUND);
        }
        QueryResult<List<CmsConfig>> result = new QueryResult<>();
        result.setData(configList);
        result.setTotal(configList.size());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }

    @Override
    public QueryResponseResult findCmsConfigById(String id) {
        Optional<CmsConfig> cmsConfigOptional = this.configRepository.findById(id);
        if (!cmsConfigOptional.isPresent()) {
            RevanThrowException.throwException(CommonCode.CMS_CONFIG_NOT_FOUND);
        }
        QueryResult<CmsConfig> result = new QueryResult<>();
        result.setData(cmsConfigOptional.get());
        return new QueryResponseResult(CommonCode.SUCCESS, result);
    }
}
