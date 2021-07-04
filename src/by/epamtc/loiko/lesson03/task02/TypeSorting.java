package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public enum TypeSorting {

    ASCENDING ("по возрастанию"),
    DESCENDING("по убыванию");

    private String type;

    TypeSorting(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TypeSorting{name = " + type + "}";
    }
}