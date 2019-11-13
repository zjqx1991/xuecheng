package com.revanwang.xc.framework.model.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryResponseResult extends BaseResponseResult {

    private QueryResult queryResult;

    public QueryResponseResult(IResultCode resultCode, QueryResult queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
