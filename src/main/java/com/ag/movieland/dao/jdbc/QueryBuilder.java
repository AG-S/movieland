package com.ag.movieland.dao.jdbc;

import com.ag.movieland.dao.common.RequestParameters;

public class QueryBuilder {
    private static final String ORDER_BY = " order by ";
    private String basicQuery;
    private RequestParameters requestParameters;

    public QueryBuilder(String basicQuery, RequestParameters sortingParameters) {
        this.basicQuery = basicQuery;
        this.requestParameters = sortingParameters;
    }

    private String makeOrderClause() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(basicQuery);
        stringBuilder.append(ORDER_BY);
        stringBuilder.append(requestParameters.getFieldName().toString());
        stringBuilder.append(" ");
        stringBuilder.append(requestParameters.getSortingDirection().toString());
        return stringBuilder.toString();
    }

    public String getSQL() {
        if (requestParameters.getFieldName() == null) {
            return basicQuery;
        } else {
            return makeOrderClause();
        }
    }

}
