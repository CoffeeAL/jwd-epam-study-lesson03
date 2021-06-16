package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public enum TypeSorting {

    ASCENDING ("по возрастанию"),
    DESCENDING("по убыванию");

    private String name;

    TypeSorting(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeSorting{name = " + name + "}";
    }
}