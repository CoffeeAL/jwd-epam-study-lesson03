package by.epamtc.loiko.lesson03.util;

import by.epamtc.loiko.lesson03.task01.Array;
import by.epamtc.loiko.lesson03.task02.Limit;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class ArrayUtil {

    public static void bubbleSortArray(Array sourceArray) {
        int[] array = sourceArray.getCurrentIntArray();
        bubbleSortArray(array);
    }

    private static void bubbleSortArray(int[] array) {
        boolean needAnotherIteration = true;
        while (needAnotherIteration) {
            needAnotherIteration = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    needAnotherIteration = true;
                }
            }
        }
    }

    public static void insertionSortArray(Array sourceArray) {
        int[] array = sourceArray.getCurrentIntArray();
        insertionSortArray(array);
    }

    private static void insertionSortArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int currentElement = array[i];
            int j = i - 1;
            while (j >= 0 && currentElement < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = currentElement;
        }
    }

    public static void mergeSort(Array sourceArray, int bottomBorder, int upBorder) {
        int[] array = sourceArray.getCurrentIntArray();
        mergeSort(array, bottomBorder, upBorder);
    }

    private static void mergeSort(int[] array, int bottomBorder, int upBorder) {
        if (upBorder <= bottomBorder) {
            return;
        }
        int mid = bottomBorder + (upBorder - bottomBorder) / 2;
        mergeSort(array, bottomBorder, mid);
        mergeSort(array, mid + 1, upBorder);
        int[] buf = new int[array.length];
        for (int k = bottomBorder; k <= upBorder; k++) {
            buf[k] = array[k];
        }
        int i = bottomBorder, j = mid + 1;
        for (int k = bottomBorder; k <= upBorder; k++) {
            if (i > mid) {
                array[k] = buf[j];
                j++;
            } else if (j > upBorder) {
                array[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                array[k] = buf[j];
                j++;
            } else {
                array[k] = buf[i];
                i++;
            }
        }
    }

    public static int findLimitElement(Array sourceArray, Limit limit) {
        int[] array = sourceArray.getCurrentIntArray();
        return findLimitElement(array, limit);
    }

    public static int findLimitElement(int[] array, Limit limit) {
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if ((limit == Limit.MAX_ELEMENT && result < array[i]) || (limit == Limit.MIN_ELEMENT && result > array[i])) {
                result = array[i];
            }
        }
        return result;
    }
}