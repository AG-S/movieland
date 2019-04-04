package com.ag.movieland.dao.common;

public enum SortingDirection {
    ASC("asc"), DESC("desc");

    SortingDirection(String direction) {
        this.direction = direction;
    }

    private String direction;

    public static SortingDirection getDirection(String value) {
        if (value != null) {
            for (SortingDirection sortingDirection : SortingDirection.values()) {
                if (value.equalsIgnoreCase(sortingDirection.direction)) {
                    return sortingDirection;
                }
            }
        }
        throw new IllegalArgumentException("No such value '"+ value +"' for ordering");
    }

}
