package com.bookSystem.useCase;

public enum BookPositionStatus {
    /**
     * Public enum for book position status whether it is lended or not.
     */
    UNLENDED, LENDED;

    public static String toString(BookPositionStatus status) {
        if (status.equals(UNLENDED)){
        return "unlended";}
        else { return "lended";
    }
    }
}

