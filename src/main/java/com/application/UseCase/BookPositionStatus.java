package com.application.UseCase;

public enum BookPositionStatus {
    UNLENDED, LENDED;

    public static String toString(BookPositionStatus status) {
        if (status.equals(UNLENDED)){
        return "UNLENDED";}
        else { return "LENDED";
    }
    }
}

