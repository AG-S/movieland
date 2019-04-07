package com.ag.movieland.dao.common;

public class RequestParameters {

    private SortingColumn fieldName;
    private SortingDirection sortingDirection;
    private static ValidatorRequestParameters validatorRequestParameters = new ValidatorRequestParameters();

    public void addSortingParameters(SortingDirection ratingOrdering, SortingDirection priceOrdering) {
        if (ratingOrdering != null) {
            validatorRequestParameters.isFieldAndOrderingCombinationAllowed(SortingColumn.RATING, ratingOrdering);
            sortingDirection = ratingOrdering;
            fieldName = SortingColumn.RATING;
            return;
        }
        if (priceOrdering != null) {
            validatorRequestParameters.isFieldAndOrderingCombinationAllowed(SortingColumn.PRICE, priceOrdering);
            sortingDirection = priceOrdering;
            fieldName = SortingColumn.PRICE;
            return;
        }
    }

    public SortingColumn getFieldName() {
        return fieldName;
    }

    public SortingDirection getSortingDirection() {
        return sortingDirection;
    }
}
