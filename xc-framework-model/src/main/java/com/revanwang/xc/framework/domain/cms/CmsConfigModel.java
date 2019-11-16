package com.revanwang.xc.framework.domain.cms;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CmsConfigModel {
    private String key;         //主键
    private String name;        //项目名称
    private String url;         //项目url
    private Map mapValue;       //项目负责值
    private String value;       //项目简单值
}
