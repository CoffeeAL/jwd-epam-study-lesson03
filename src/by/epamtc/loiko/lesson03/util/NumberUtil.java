package by.epamtc.loiko.lesson03.util;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class NumberUtil {

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFibonacciNumber(int number) {
        if (number < 0) {
            return false;
        }
        if (number == 0 || number == 1) {
            return true;
        }
        int previous = 1;
        int next = previous;
        while (next < number) {
            int temp = next;
            next += previous;
            previous = temp;
            if (next == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasDifferentDigitsThreeDigitNumber(int sourceNumber) {
        int absoluteNumber = Math.abs(sourceNumber);
        if (absoluteNumber < 100  || absoluteNumber > 999) {
            return false;
        }
        int units = absoluteNumber % 10;
        int dozens = (absoluteNumber - units) / 10 % 10;
        int hundreds = (absoluteNumber - dozens * 10 - units) / 100;
        return !(units == dozens || units == hundreds || dozens == hundreds);
    }
}