package com.revanwang.xc.manage_cms.dao;

import com.revanwang.xc.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICmsSiteRepository extends MongoRepository<CmsSite, String> {
}
