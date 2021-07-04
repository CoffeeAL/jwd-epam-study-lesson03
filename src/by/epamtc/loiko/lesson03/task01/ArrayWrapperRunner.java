package by.epamtc.loiko.lesson03.task01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

import by.epamtc.loiko.lesson03.exception.IllegalArrayValueCapacityException;
import by.epamtc.loiko.lesson03.exception.IllegalIntervalException;
import by.epamtc.loiko.lesson03.exception.NullArrayException;
import by.epamtc.loiko.lesson03.task02.Limit;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Создайте тип Array, который является оболочкой над массивом целого типа. В этом типе должны быть реализованы
 * конструкторы (позволяющие несколькими способами создавать объекты типа), геттеры, сеттеры и переопределённые методы
 * класса Object (toString(), equals(), hashCode()).
 * Реализовать возможности:
 * 1) сортировка тремя способами
 * 2) поиск элемента массива (использовать алгоритм бинарного поиска)
 * 3) находить максимальный и минимальный элементы массива
 * 4) получать все простые числа из массива
 * 5) получать все числа Фибоначчи из массива
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, …
 * 6) получать все трёхзначные числа, в десятичной записи которых нет одинаковых цифр
 * 7) заполнять элементы массива и с консоли, и с файла, и с помощью рандома
 */
public class ArrayWrapperRunner {

    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_INTERVAL = 1000;

    public static void main(String[] args) {
        try {
            arrayStandardDemo();
            arrayFromConsoleDemo(DEFAULT_CAPACITY);
            arrayRandomDemo(DEFAULT_CAPACITY, DEFAULT_INTERVAL);
            arrayFromFileDemo(DEFAULT_CAPACITY);
        } catch (IllegalArrayValueCapacityException | IllegalIntervalException | NullArrayException | FileNotFoundException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void arrayStandardDemo() throws NullArrayException {
        System.out.println("Демонстрация массива, заполненного стандартным способом.");
        int[] sourceArray = {4, -54, 5, 1, 17, 55, 567};
        Array array = new Array(sourceArray);
        int[] arrayAsWrapperField = array.getCurrentIntArray();
        array.mergeSortArray();
        printReport(array);
        Interval interval = new Interval(0, arrayAsWrapperField.length - 1);
        int valueForBinarySearch = 4;
        int binarySearchIndex = array.binarySearchElement(interval, valueForBinarySearch);
        if (binarySearchIndex == -1) {
            printReportElementAbsent(valueForBinarySearch);
        } else {
            printReportElementExists(valueForBinarySearch, binarySearchIndex);
        }
    }

    public static void printReportElementAbsent(int searchValue) {
        System.out.printf("Элемент %d в массиве не найден\n", searchValue);
    }

    public static void printReportElementExists(int searchValue, int index) {
        System.out.printf("%d имеет индекс %d в отсортированном массиве\n", searchValue, index);
    }

    public static void arrayFromConsoleDemo(int arrayCapacity)
            throws IllegalArrayValueCapacityException, NullArrayException {
        System.out.println("Демонстрация массива, заполненного через консоль.");
        checkArrayCapacity(arrayCapacity);
        Array array = new Array(arrayCapacity);
        array.fillArrayFromConsole();
        printReport(array);
    }

    public static void arrayFromFileDemo(int arrayCapacity)
            throws IllegalArrayValueCapacityException, FileNotFoundException, NullArrayException {
        System.out.println("Демонстрация массива, заполненного из файла.");
        checkArrayCapacity(arrayCapacity);
        Array array = new Array(arrayCapacity);
        File sourceFile = new File("resources/IntegerData.txt");
        array.fillArrayFromFile(sourceFile);
        printReport(array);
    }

    public static void arrayRandomDemo(int arrayCapacity, int interval)
            throws IllegalIntervalException, IllegalArrayValueCapacityException, NullArrayException {
        System.out.println("Демонстрация массива, заполненного случайными числами.");
        checkArrayCapacity(arrayCapacity);
        checkInterval(interval);
        Array array = new Array(10);
        array.fillArrayWithRandomNumbers(100);
        printReport(array);
    }

    public static void printReport(Array array) throws NullArrayException {
        checkArrayNotNull(array);
        System.out.println(array);
        System.out.println("Минимальный элемент массива: " + array.findLimitElement(Limit.MIN_ELEMENT));
        System.out.println("Максимальный элемент массива: " + array.findLimitElement(Limit.MAX_ELEMENT));
        printPrimesNumbersFromArray(array);
        printFibonacciNumbersFromArray(array);
        printThreeDifferentDigitNumbersFromArray(array);
    }

    private static void printPrimesNumbersFromArray(Array array) {
        System.out.print("Простые числа из массива: ");
        String allPrimeNumbers = array.findAllPrimeNumbers();
        System.out.println(allPrimeNumbers);
    }

    private static void printFibonacciNumbersFromArray(Array array) {
        System.out.print("Числа Фибоначчи из массива: ");
        String allFibonacciNumbers = array.findAllFibonacciNumbers();
        System.out.println(allFibonacciNumbers);
    }

    private static void printThreeDifferentDigitNumbersFromArray(Array array) {
        System.out.print("Трёхзначные числа из массива с разными цифрами: ");
        String allThreeDifferentDigitNumbers = array.findAllThreeDifferentDigitNumbers();
        System.out.println(allThreeDifferentDigitNumbers);
    }

    public static void checkArrayNotNull(Array array) throws NullArrayException {
        if(array == null) {
            throw new NullArrayException("Массив не определён.");
        }
    }

    public static void checkArrayCapacity(int arrayCapacity) throws IllegalArrayValueCapacityException {
        if (arrayCapacity < 0) {
            throw new IllegalArrayValueCapacityException("Размер массива не может принимать отрицательное значение.");
        }
    }

    public static void checkInterval(int interval) throws IllegalIntervalException {
        if (interval <= 0) {
            throw new IllegalIntervalException("Интервал должен принимать положительное значение.");
        }
    }
}