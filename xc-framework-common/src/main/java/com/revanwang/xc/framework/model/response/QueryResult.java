package com.revanwang.xc.framework.model.response;

import lombok.Data;

import java.util.List;

@Data
public class QueryResult<T> {
    //数据列表
    private List<T> list;
    //数据总数
    private long total;
}
