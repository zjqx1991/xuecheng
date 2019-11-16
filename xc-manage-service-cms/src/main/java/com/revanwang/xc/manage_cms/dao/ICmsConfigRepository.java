package com.revanwang.xc.manage_cms.dao;

import com.revanwang.xc.framework.domain.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICmsConfigRepository extends MongoRepository<CmsConfig, String> {
}
