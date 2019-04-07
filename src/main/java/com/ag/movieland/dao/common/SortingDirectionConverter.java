package com.ag.movieland.dao.common;

import java.beans.PropertyEditorSupport;

public class SortingDirectionConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(SortingDirection.getDirection(text));
    }
}
