package com.ag.movieland.dao.common;

import java.util.HashMap;
import java.util.Map;

public class SortingParameters {
    private final static String RATING = "rating";
    private final static String PRICE = "price";
    private static Map<String, SortingDirection> notAllowedCombination = new HashMap<>();
    private String fieldName;
    private SortingDirection sortingDirection;

    public SortingParameters() {
        notAllowedCombination.put(RATING, SortingDirection.ASC);
    }

    public void addSortingParameters(String ratingOrdering, String priceOrdering) {
        if (ratingOrdering != null) {
            isFieldAndOrderingCombinationAllowed(RATING, SortingDirection.getDirection(ratingOrdering));
            sortingDirection = SortingDirection.getDirection(ratingOrdering);
            fieldName = RATING;
            return;
        }
        if (priceOrdering != null) {
            isFieldAndOrderingCombinationAllowed(PRICE, SortingDirection.getDirection(priceOrdering));
            sortingDirection = SortingDirection.getDirection(priceOrdering);
            fieldName = PRICE;
            return;
        }
    }

    private void isFieldAndOrderingCombinationAllowed(String fieldName, SortingDirection direction) {
        notAllowedCombination.get(fieldName);
        if (notAllowedCombination.containsKey(fieldName)) {
            if (notAllowedCombination.get(fieldName).equals(direction)) {
                throw new IllegalArgumentException("Invalid combination of name: '" + fieldName + "', order: '" + direction.toString() + "'");
            }
        }
    }

    public String getFieldName() {
        return fieldName;
    }

    public SortingDirection getSortingDirection() {
        return sortingDirection;
    }
}
