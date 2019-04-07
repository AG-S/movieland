package com.ag.movieland.dao.common;

import java.util.HashMap;
import java.util.Map;

public class ValidatorRequestParameters {
    private static Map<SortingColumn, SortingDirection> notAllowedCombination = new HashMap<>();

    ValidatorRequestParameters() {
        notAllowedCombination.put(SortingColumn.RATING, SortingDirection.ASC);
    }

    public static void isFieldAndOrderingCombinationAllowed(SortingColumn fieldName, SortingDirection direction) {
        notAllowedCombination.get(fieldName);
        if (notAllowedCombination.containsKey(fieldName)) {
            if (notAllowedCombination.get(fieldName).equals(direction)) {
                throw new IllegalArgumentException("Invalid combination of name: '" + fieldName.toString() + "', order: '" + direction.toString() + "'");
            }
        }
    }
}
