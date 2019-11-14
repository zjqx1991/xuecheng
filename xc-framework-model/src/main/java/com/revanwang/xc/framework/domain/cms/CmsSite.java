package com.revanwang.xc.framework.domain.cms;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cms_site")
public class CmsSite {
    @Id
    private String id;
    private String siteName;
    private String siteDomain;
    private String sitePort;
    private String siteWebPath;
    private String siteCreateTime;
}
