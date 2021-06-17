package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

import by.epamtc.loiko.lesson03.exception.NullArrayException;
import by.epamtc.loiko.lesson03.exception.NullLimitException;
import by.epamtc.loiko.lesson03.exception.NullTypeSortingException;
import by.epamtc.loiko.lesson03.util.ArrayUtil;

/**
 * Дан непрямоугольный целочисленный массив. Реализовать алгоритм пузырьковой сортировки, чтобы была возможность
 * упорядочить строки матрицы:
 * - в порядке возрастания (убывания) сумм элементов строк матрицы;
 * - в порядке возрастания (убывания) максимальных элементов строк матрицы;
 * - в порядке возрастания (убывания) минимальных элементов строк матрицы;
 * Для сортировки методы класса Arrays не использовать. Основное требование - избежать повтора кода
 */
public class JaggedArrayRunner {

    public static void main(String[] args) {
        int[][] sourceArray = new int[][]{{2, 7, 22}, {50, -2, -8}, {1, 3}, {1, -7, 12, -8}, {3, 18, 6, -11, 1}};
        try {
            int[][] sortedBySumElements = sortBySumElements(sourceArray, TypeSorting.ASCENDING);
            printReport(sortedBySumElements);
            int[][] sortedByMaxElementAscending = sortByLimitElements(sourceArray, Limit.MAX_ELEMENT,
                    TypeSorting.ASCENDING);
            printReport(sortedByMaxElementAscending);
            int[][] sortedByMinElementDescending = sortByLimitElements(sourceArray, Limit.MIN_ELEMENT,
                    TypeSorting.DESCENDING);
            printReport(sortedByMinElementDescending);
        } catch (NullArrayException | NullTypeSortingException | NullLimitException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static int[][] sortBySumElements(int[][] matrix, TypeSorting typeSorting)
            throws NullArrayException, NullTypeSortingException {
        if (matrix == null) {
            throw new NullArrayException("Массив для сортировки отсутствует.");
        }
        checkTypeSorting(typeSorting);
        System.out.println("Сортировка массива по сумме элементов " + typeSorting.getName());
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < matrix.length; i++) {
                if (needSwapWhileSortingBySum(typeSorting, matrix[i - 1], matrix[i])) {
                    int[] temp = matrix[i];
                    matrix[i] = matrix[i - 1];
                    matrix[i - 1] = temp;
                    needIteration = true;
                }
            }
        }
        return matrix;
    }

    public static int[][] sortByLimitElements(int[][] matrix, Limit limit, TypeSorting typeSorting)
            throws NullArrayException, NullTypeSortingException, NullLimitException {
        if (matrix == null) {
            throw new NullArrayException("Массив для сортировки отсутствует.");
        }
        checkTypeSorting(typeSorting);
        checkLimit(limit);
        System.out.println("Сортировка массива " + limit.getLimit() + " " + typeSorting.getName());
        boolean needIteration = true;
        while (needIteration) {
            needIteration = false;
            for (int i = 1; i < matrix.length; i++) {
                if (needSwapWhileSortingByElements(limit, typeSorting, matrix[i - 1], matrix[i])) {
                    int[] temp = matrix[i];
                    matrix[i] = matrix[i - 1];
                    matrix[i - 1] = temp;
                    needIteration = true;
                }
            }
        }
        return matrix;
    }

    public static int findSubarraySumElements(int[] array) throws NullArrayException {
        if (array == null) {
            throw new NullArrayException("Массив для поиска суммы элементов отсутствует.");
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static boolean needSwapWhileSortingBySum(TypeSorting typeSorting, int[] previous, int[] next)
            throws NullArrayException, NullTypeSortingException {
        if (previous == null || next == null) {
            throw new NullArrayException("Массив отсутствует.");
        }
        checkTypeSorting(typeSorting);
        return findSubarraySumElements(next) < findSubarraySumElements(previous) && typeSorting == TypeSorting.ASCENDING ||
                findSubarraySumElements(next) > findSubarraySumElements(previous) && typeSorting == TypeSorting.DESCENDING;
    }

    public static boolean needSwapWhileSortingByElements(Limit limit, TypeSorting typeSorting, int[] previous,
                                                         int[] next) throws NullArrayException, NullTypeSortingException, NullLimitException {
        if (previous == null || next == null) {
            throw new NullArrayException("Массив отсутствует.");
        }
        checkTypeSorting(typeSorting);
        checkLimit(limit);
        return limit == Limit.MAX_ELEMENT && typeSorting == TypeSorting.ASCENDING && ArrayUtil.findElement(previous, Limit.MAX_ELEMENT) > ArrayUtil.findElement(next, Limit.MAX_ELEMENT) ||
                limit == Limit.MAX_ELEMENT && typeSorting == TypeSorting.DESCENDING && ArrayUtil.findElement(previous, Limit.MAX_ELEMENT) < ArrayUtil.findElement(next, Limit.MAX_ELEMENT) ||
                limit == Limit.MIN_ELEMENT && typeSorting == TypeSorting.ASCENDING && ArrayUtil.findElement(previous, Limit.MIN_ELEMENT) > ArrayUtil.findElement(next, Limit.MIN_ELEMENT) ||
                limit == Limit.MIN_ELEMENT && typeSorting == TypeSorting.DESCENDING && ArrayUtil.findElement(previous, Limit.MIN_ELEMENT) < ArrayUtil.findElement(next, Limit.MIN_ELEMENT);
    }

    public static void printReport(int[][] targetArray) throws NullArrayException {
        if (targetArray == null) {
            throw new NullArrayException("Массив для выведения на печать отсутствует.");
        }
        for (int[] array : targetArray) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static void checkLimit(Limit limit) throws NullLimitException {
        if (limit == null) {
            throw new NullLimitException("Не указан предел сортировки (по максимальному или по минимальному значению.");
        }
    }

    public static void checkTypeSorting(TypeSorting typeSorting) throws NullTypeSortingException {
        if (typeSorting == null) {
            throw new NullTypeSortingException("Не указан тип сортировки.");
        }
    }
}