package UseCase;

public enum BookPositionStatus {
    UNLENDED, LENDED;

    public static String toString(BookPositionStatus status) {
        if (status.equals(UNLENDED)){
        return "unlended";}
        else { return "lended";
    }
    }
}

