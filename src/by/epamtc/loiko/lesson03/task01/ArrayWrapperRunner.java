package by.epamtc.loiko.lesson03.task01;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

import by.epamtc.loiko.lesson03.task02.Limit;

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
 *      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, …
 * 6) получать все трёхзначные числа, в десятичной записи которых нет одинаковых цифр
 * 7) заполнять элементы массива и с консоли, и с файла, и с помощью рандома
 */
public class ArrayWrapperRunner {

    public static void main(String[] args) {
        int[] sourceArray = {4, -54, 1, 55};
        Array array = new Array(sourceArray);
        int[] targetArray = array.getCurrentIntArray();
        //array.bubbleSortArray();
        //array.insertionSortArray();
        //ArraySortUtil.mergeSort(targetArray, 0, targetArray.length - 1);
        //array.sortArray(targetArray);
        System.out.println(array.toString());
        //array.printAllFibonacciNumbers();
        System.out.println("Минимальный элемент массива: " + array.findLimitElement(Limit.MIN_ELEMENT));
        System.out.println("Максимальный элемент массива: " + array.findLimitElement(Limit.MAX_ELEMENT));

        //array.printAllThreeDifferentDigitNumbers();

        //array.printPrimesNumbersFromArray();
    }
}