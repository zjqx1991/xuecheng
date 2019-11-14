package com.revanwang.xc.manage_cms.dao;

import com.revanwang.xc.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICmsTemplateRepository extends MongoRepository<CmsTemplate, String> {
}
