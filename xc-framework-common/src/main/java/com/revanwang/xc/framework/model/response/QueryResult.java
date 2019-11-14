package com.revanwang.xc.framework.model.response;

import lombok.Data;


@Data
public class QueryResult<T> {
    //数据列表
    private T data;
    //数据总数
    private long total;
}
