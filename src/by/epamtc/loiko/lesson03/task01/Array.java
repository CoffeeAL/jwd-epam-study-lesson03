package by.epamtc.loiko.lesson03.task01;

import by.epamtc.loiko.lesson03.task02.Limit;
import by.epamtc.loiko.lesson03.util.ArrayUtil;
import by.epamtc.loiko.lesson03.util.NumberUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

public class Array implements Serializable {

    private static final int DEFAULT_CAPACITY = 10;
    private int initialArrayCapacity;
    private int[] currentIntArray;

    public Array() {
        initialArrayCapacity = DEFAULT_CAPACITY;
        currentIntArray = new int[initialArrayCapacity];
    }

    public Array(int initialArrayCapacity) {
        this.initialArrayCapacity = initialArrayCapacity;
        currentIntArray = new int[this.initialArrayCapacity];
    }

    public Array(int[] intArray) {
        initialArrayCapacity = intArray.length;
        currentIntArray = intArray;
    }

    public void bubbleSortArray() {
        ArrayUtil.bubbleSortArray(this);
    }

    public void insertionSortArray() {
        ArrayUtil.insertionSortArray(this);
    }

    public void mergeSortArray() {
        ArrayUtil.mergeSort(this, 0,
                currentIntArray.length - 1);
    }

    public int binarySearchElement(Interval interval, int valueForSearch) {
        int index = -1;
        int borderIndex = (interval.getFirstIndex() + interval.getLastIndex()) / 2;
        if (currentIntArray[borderIndex] == valueForSearch) {
            index = borderIndex;
        }
        while ((currentIntArray[borderIndex] != valueForSearch) && (interval.getFirstIndex() <= interval.getLastIndex())) {
            if (currentIntArray[borderIndex] > valueForSearch) {
                interval.setLastIndex(borderIndex - 1);
            } else {
                interval.setFirstIndex(borderIndex + 1);
            }
            borderIndex = (interval.getFirstIndex() + interval.getLastIndex()) / 2;
            if (currentIntArray[borderIndex] == valueForSearch) {
                index = borderIndex;
            }
        }
        return index;
    }

    public int findLimitElement(Limit limit) {
        int result = ArrayUtil.findLimitElement(this, limit);
        return result;
    }

    public String findAllPrimeNumbers() {
        StringBuilder primeNumbers = new StringBuilder();
        for (int i = 0; i < currentIntArray.length; i++) {
            if (NumberUtil.isPrimeNumber(currentIntArray[i])) {
                primeNumbers.append(currentIntArray[i] + " ");
            }
        }
        return primeNumbers.toString().trim();
    }

    public String findAllFibonacciNumbers() {
        StringBuilder fibonacciNumbers = new StringBuilder();
        for (int i = 0; i < currentIntArray.length; i++) {
            if (NumberUtil.isFibonacciNumber(currentIntArray[i])) {
                fibonacciNumbers.append(currentIntArray[i] + " ");
            }
        }
        return fibonacciNumbers.toString().trim();
    }

    public String findAllThreeDifferentDigitNumbers() {
        StringBuilder threeDigitNumbersWithDifferentDigits = new StringBuilder();
        for (int i = 0; i < currentIntArray.length; i++) {
            if (NumberUtil.hasDifferentDigitsThreeDigitNumber(currentIntArray[i])) {
                threeDigitNumbersWithDifferentDigits.append(currentIntArray[i] + " ");
            }
        }
        return threeDigitNumbersWithDifferentDigits.toString().trim();
    }

    public void fillArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        fillArray(scanner);
    }

    public void fillArrayFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        fillArray(scanner);
    }

    private void fillArray(Scanner scanner) {
        int i = 0;
        while (scanner.hasNextInt()) {
            currentIntArray[i++] = scanner.nextInt();
            if (i == currentIntArray.length) {
                break;
            }
        }
    }

    public void fillArrayWithRandomNumbers(int limit) {
        for (int i = 0; i < currentIntArray.length; i++) {
            currentIntArray[i] = (int) (Math.random() * limit);
        }
    }

    public int[] getCurrentIntArray() {
        return currentIntArray;
    }

    public void setCurrentIntArray(int[] currentIntArray) {
        this.currentIntArray = currentIntArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Array)) {
            return false;
        }
        Array comparedArray = (Array) o;
        int[] targetArray = comparedArray.currentIntArray;
        if (currentIntArray.length != targetArray.length) return false;
        for (int i = 0; i < currentIntArray.length; i++) {
            if (currentIntArray[i] != targetArray[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = initialArrayCapacity;
        for (int i = 0; i < currentIntArray.length; i++) {
            result = 31 * result + 7 * currentIntArray[i];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder arrayAsString = new StringBuilder("This array: {");
        for (int i = 0; i < currentIntArray.length; i++) {
            arrayAsString.append(i == currentIntArray.length - 1 ? currentIntArray[i] + "}" : currentIntArray[i] + ", ");
        }
        return arrayAsString.toString();
    }
}