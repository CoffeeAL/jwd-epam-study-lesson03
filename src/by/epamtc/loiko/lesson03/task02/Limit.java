package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public enum Limit {

    MAX_ELEMENT ("по максимальному значению"),
    MIN_ELEMENT ("по минимальному значению");

    private String border;

    Limit(String border) {
        this.border = border;
    }

    public String getBorder() {
        return border;
    }

    @Override
    public String toString() {
        return "Limit{limit = " + border + "}";
    }
}