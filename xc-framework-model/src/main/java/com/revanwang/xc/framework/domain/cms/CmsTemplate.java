package com.revanwang.xc.framework.domain.cms;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cms_template")
public class CmsTemplate {
    @Id
    private String id;
    private String siteId;
    private String templateName;
    private String templateParameter;
    private String templateFileId;
}
