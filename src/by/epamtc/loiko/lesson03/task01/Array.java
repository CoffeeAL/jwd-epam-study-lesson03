package by.epamtc.loiko.lesson03.task01;

import by.epamtc.loiko.lesson03.task02.Limit;
import by.epamtc.loiko.lesson03.util.ArrayUtil;

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
        currentIntArray = new int[initialArrayCapacity];
    }

    public Array(int[] intArray) {
        initialArrayCapacity = intArray.length;
        this.currentIntArray = intArray;
    }

    public void bubbleSortArray() {
        ArrayUtil.bubbleSortArray(currentIntArray);
    }

    public void insertionSortArray() {
        ArrayUtil.insertionSortArray(currentIntArray);
    }

    public void mergeSortArray() {
        ArrayUtil.mergeSort(currentIntArray, 0, currentIntArray.length - 1);
    }

    public void findElement(int value) {
        mergeSortArray();
        binarySearch(0, currentIntArray.length - 1, value);
    }

    public void binarySearch(int firstIndex, int lastIndex, int searchValue) {
        int position;
        int comparisonCount = 1;
        position = (firstIndex + lastIndex) / 2;
        while ((currentIntArray[position] != searchValue) && (firstIndex <= lastIndex)) {
            comparisonCount++;
            if (currentIntArray[position] > searchValue) {
                lastIndex = position - 1;
            } else {
                firstIndex = position + 1;
            }
            position = (firstIndex + lastIndex) / 2;
        }
        if (firstIndex <= lastIndex) {
            System.out.println(searchValue + " является " + ++position + " элементом в отсортированном массиве");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount +
                    " сравнений");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска закончил работу после "
                    + comparisonCount + " сравнений");
        }
    }

    public int findLimitElement(Limit limit) {
        return ArrayUtil.findElement(currentIntArray, limit);
    }

    public void printPrimesNumbersFromArray() {
        System.out.print("Простые числа из массива: ");
        findPrimeNumbers();
        System.out.println();
    }

    public void findPrimeNumbers() {
        for (int i = 0; i < currentIntArray.length; i++) {
            if (isPrimeNumber(currentIntArray[i])) {
                System.out.print(currentIntArray[i] + " ");
            }
        }
    }

    public boolean isPrimeNumber(int number) {
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

    public void printAllFibonacciNumbers() {
        System.out.print("Числа Фибоначчи: ");
        for (int i = 0; i < currentIntArray.length; i++) {
            if (isFibonacciNumber(currentIntArray[i])) {
                System.out.print(currentIntArray[i] + " ");
            }
        }
        System.out.println();
    }

    public boolean isFibonacciNumber(int number) {
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

    public void printAllThreeDifferentDigitNumbers() {
        System.out.print("Трёхзначные числа со всеми разными цифрами: ");
        for (int i = 0; i < currentIntArray.length; i++) {
            currentIntArray[i] = Math.abs(currentIntArray[i]);
            if (currentIntArray[i] > 99 && currentIntArray[i] < 1000 && hasDifferentDigits(currentIntArray[i])) {
                System.out.println(currentIntArray[i]);
            }
        }
        System.out.println();
    }

    public boolean hasDifferentDigits(int number) {
        int units = number % 10;
        int dozens = (number - units) / 10 % 10;
        int hundreds = (number - dozens * 10 - units) / 100;
        return (units == dozens || units == hundreds || dozens == hundreds) ? false : true;
    }

    public void fillArrayFromConsole() {
        Scanner scanner = new Scanner(System.in);
        fillArray(scanner);
    }

    public void fillArrayFromFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        fillArray(scanner);
    }

    public void fillArray(Scanner scanner) {
        int i = 0;
        while (scanner.hasNextInt()) {
            currentIntArray[i++] = scanner.nextInt();
            if (i == currentIntArray.length) {
                break;
            }
        }
    }

    public void fillArrayWithRandomNumbers(int randomInterval) {
        for (int i = 0; i < currentIntArray.length; i++) {
            currentIntArray[i] = (int) (Math.random() * randomInterval);
        }
    }

    public int getInitialArrayCapacity() {
        return initialArrayCapacity;
    }

    public void setInitialArrayCapacity(int initialArrayCapacity) {
        this.initialArrayCapacity = initialArrayCapacity;
    }

    public int[] getCurrentIntArray() {
        return currentIntArray;
    }

    public void setCurrentIntArray(int[] currentIntArray) {
        this.currentIntArray = currentIntArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array comparedArray = (Array) o;
        int[] targetArray = comparedArray.currentIntArray;
        if (currentIntArray.length != targetArray.length) return false;
        for (int i : targetArray) {
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