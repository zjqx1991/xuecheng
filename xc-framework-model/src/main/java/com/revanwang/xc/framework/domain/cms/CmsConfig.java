package com.revanwang.xc.framework.domain.cms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * 配置数据
 */

@Getter
@Setter
@Document(collection = "cms_config")
public class CmsConfig {
    @Id
    private String id;      //主键
    private String name;    //数据模型的名称
    private List<CmsConfigModel> model;     //数据模型项目
}
