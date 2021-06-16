package by.epamtc.loiko.lesson03.task02;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */

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
        int[][] sourceArray = new int[][]{{2, 7, 2}, {1, 3}, {1, 7, 2, 1}, {3, 8, 6, 1, 1}};
        //int[][] targetArray = sortMatrix(sourceArray);
        int[][] sortedArray = sortBySumElements(sourceArray, TypeSorting.ASCENDING);
        printReport(sortedArray);
    }

    public static int[][] sortBySumElements(int[][] matrix, TypeSorting typeSorting) {
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

    public static int[][] sortByLimitElements(int[][] matrix, Limit limit, TypeSorting typeSorting) {
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

    public static int findSubarraySumElements(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static boolean needSwapWhileSortingBySum(TypeSorting typeSorting, int[] previous, int[] next) {
        return findSubarraySumElements(next) < findSubarraySumElements(previous) && typeSorting == TypeSorting.ASCENDING ||
                findSubarraySumElements(next) > findSubarraySumElements(previous) && typeSorting == TypeSorting.DESCENDING;
    }

    public static boolean needSwapWhileSortingByElements(Limit limit, TypeSorting typeSorting, int[] previous, int[] next) {
        return limit == Limit.MAX_ELEMENT && typeSorting == TypeSorting.ASCENDING && ArrayUtil.findElement(previous, Limit.MAX_ELEMENT) > ArrayUtil.findElement(next, Limit.MAX_ELEMENT) ||
                limit == Limit.MAX_ELEMENT && typeSorting == TypeSorting.DESCENDING && ArrayUtil.findElement(previous, Limit.MAX_ELEMENT) < ArrayUtil.findElement(next, Limit.MAX_ELEMENT) ||
                limit == Limit.MIN_ELEMENT && typeSorting == TypeSorting.ASCENDING && ArrayUtil.findElement(previous, Limit.MIN_ELEMENT) > ArrayUtil.findElement(next, Limit.MIN_ELEMENT) ||
                limit == Limit.MIN_ELEMENT && typeSorting == TypeSorting.DESCENDING && ArrayUtil.findElement(previous, Limit.MIN_ELEMENT) < ArrayUtil.findElement(next, Limit.MIN_ELEMENT);
    }

    public static void printReport(int[][] targetArray) {
        for (int[] array : targetArray) {
            for (int number : array) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}