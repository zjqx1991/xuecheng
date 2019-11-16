package com.revanwang.xc.manage_cms.service;

import com.revanwang.xc.framework.model.response.QueryResponseResult;

public interface ICmsConfigService {

    /**
     * 获取配置列表
     */
    QueryResponseResult findCmsConfigList();

    /**
     * 获取配置对象
     */
    QueryResponseResult findCmsConfigById(String id);
}
