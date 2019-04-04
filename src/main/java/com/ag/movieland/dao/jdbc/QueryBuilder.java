package com.ag.movieland.dao.jdbc;

import com.ag.movieland.dao.common.SortingParameters;

public class QueryBuilder {
    private static final String ORDER_BY = " order by ";
    private String basicQuery;
    private SortingParameters sortingParameters;

    public QueryBuilder(String basicQuery, SortingParameters sortingParameters) {
        this.basicQuery = basicQuery;
        this.sortingParameters = sortingParameters;
    }

    private String makeOrderClause() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(basicQuery);
        stringBuilder.append(ORDER_BY);
        stringBuilder.append(sortingParameters.getFieldName());
        stringBuilder.append(" ");
        stringBuilder.append(sortingParameters.getSortingDirection().toString());
        return stringBuilder.toString();
    }

    public String getSQL() {
        if (sortingParameters.getFieldName() == null) {
            return basicQuery;
        } else {
            return makeOrderClause();
        }
    }

}
