package by.epamtc.loiko.lesson03.task01;

import by.epamtc.loiko.lesson03.task02.Limit;
import by.epamtc.loiko.lesson03.util.ArrayUtil;

import java.io.Serializable;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

public class Array implements Serializable {

    private int initialArrayCapacity;
    private int[] currentIntArray;

    public Array() {
        initialArrayCapacity = 10;
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

    public int findElement(int value) {
        mergeSortArray();
        int indexValue = -1;
        int startIndex = 0;
        int lastIndex = (currentIntArray.length - 1);
        while ((startIndex <= lastIndex) && (value >= currentIntArray[startIndex]) &&
                (value <= currentIntArray[lastIndex])) {
            indexValue = startIndex + (((lastIndex - startIndex) /
                    (currentIntArray[lastIndex] - currentIntArray[startIndex])) *
                    (value - currentIntArray[startIndex]));
            if (currentIntArray[indexValue] == value)
                return indexValue;
        }
        return indexValue;
    }

        public int findLimitElement (Limit limit) {
            return ArrayUtil.findElement(currentIntArray, limit);
        }

        public void printPrimesNumbersFromArray () {
            System.out.print("Простые числа из массива: ");
            for (int i = 0; i < currentIntArray.length; i++) {
                if (isPrimeNumber(currentIntArray[i])) {
                    System.out.print(currentIntArray[i] + " ");
                }
            }
        }

        public boolean isPrimeNumber ( int number){
            number = Math.abs(number);
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public void printAllFibonacciNumbers () {
            System.out.print("Числа Фибоначчи: ");
            for (int i = 0; i < currentIntArray.length; i++) {
                if (isFibonacciNumber(currentIntArray[i])) {
                    System.out.print(currentIntArray[i] + " ");
                }
            }
            System.out.println();
        }

        public boolean isFibonacciNumber ( int number){
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

        public void printAllThreeDifferentDigitNumbers () {
            for (int i = 0; i < currentIntArray.length; i++) {
                currentIntArray[i] = Math.abs(currentIntArray[i]);
                if (currentIntArray[i] > 99 && currentIntArray[i] < 1000 && hasDifferentDigits(currentIntArray[i])) {
                    System.out.println(currentIntArray[i]);
                }
            }
        }

        public boolean hasDifferentDigits ( int number){
            int units = number % 10;
            int dozens = (number - units) / 10 % 10;
            int hundreds = (number - dozens * 10 - units) / 100;
            return (units == dozens || units == hundreds || dozens == hundreds) ? false : true;
        }

        public int getInitialArrayCapacity () {
            return initialArrayCapacity;
        }

        public void setInitialArrayCapacity ( int initialArrayCapacity){
            this.initialArrayCapacity = initialArrayCapacity;
        }

        public int[] getCurrentIntArray () {
            return currentIntArray;
        }

        public void setCurrentIntArray ( int[] currentIntArray){
            this.currentIntArray = currentIntArray;
        }

        @Override
        public boolean equals (Object o){
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
        public int hashCode () {
            int result = initialArrayCapacity;
            for (int i = 0; i < currentIntArray.length; i++) {
                result = 31 * result + 7 * currentIntArray[i];
            }
            return result;
        }

        @Override
        public String toString () {
            StringBuilder arrayAsString = new StringBuilder("This array: {");
            for (int i = 0; i < currentIntArray.length; i++) {
                arrayAsString.append(i == currentIntArray.length - 1 ? currentIntArray[i] + "}" : currentIntArray[i] + ", ");
            }
            return arrayAsString.toString();
        }
    }