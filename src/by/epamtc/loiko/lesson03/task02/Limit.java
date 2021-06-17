package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public enum Limit {

    MAX_ELEMENT ("по максимальному значению"),
    MIN_ELEMENT ("по минимальному значению");

    private String limit;

    Limit(String limit) {
        this.limit = limit;
    }

    public String getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "Limit{limit = " + limit + "}";
    }
}