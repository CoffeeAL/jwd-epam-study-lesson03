package by.epamtc.loiko.lesson03.task01;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class Interval implements Serializable {

    private int firstIndex;
    private int lastIndex;

    public Interval() {
    }

    public Interval(int firstIndex, int lastIndex) {
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    @Override
    public String toString() {
        return "Interval{firstIndex = " + firstIndex + ", lastIndex = " + lastIndex + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        if (firstIndex != interval.firstIndex) return false;
        return lastIndex == interval.lastIndex;
    }

    @Override
    public int hashCode() {
        int result = firstIndex;
        result = 31 * result + lastIndex;
        return result;
    }
}