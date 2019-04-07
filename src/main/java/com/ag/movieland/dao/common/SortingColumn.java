package com.ag.movieland.dao.common;

public enum SortingColumn {
    RATING("rating"), PRICE("price");

    SortingColumn(String column) {
        this.column = column;
    }

    private String column;

    public static SortingColumn getColumn(String value) {
        if (value != null) {
            for (SortingColumn sortingColumn : SortingColumn.values()) {
                if (value.equalsIgnoreCase(sortingColumn.column)) {
                    return sortingColumn;
                }
            }
        }
        throw new IllegalArgumentException("No such column '" + value + "' for ordering");
    }
}
