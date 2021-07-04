package by.epamtc.loiko.lesson03.util;

import by.epamtc.loiko.lesson03.task01.Array;
import by.epamtc.loiko.lesson03.task02.Limit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class ArrayUtilTest {

    private int[] innerArray;
    private int[] sortedInnerArray;
    private Array outerArray;

    @Before
    public void initSourceArray() {
        innerArray = new int[]{4, 1, 6, 7, -10, -5, 7, -5};
        sortedInnerArray = new int[]{-10, -5, -5, 1, 4, 6, 7, 7};
        outerArray = new Array(innerArray);
    }

    @Test
    public void checkBubbleSort() {
        ArrayUtil.bubbleSortArray(outerArray);
        Assert.assertTrue(outerArray.equals(new Array(sortedInnerArray)));
    }

    @Test
    public void checkInsertionSort() {
        ArrayUtil.insertionSortArray(outerArray);
        Assert.assertTrue(outerArray.equals(new Array(sortedInnerArray)));
    }

    @Test
    public void checkMergeSort() {
        ArrayUtil.mergeSort(outerArray, 0, outerArray.getCurrentIntArray().length - 1);
        Assert.assertTrue(outerArray.equals(new Array(sortedInnerArray)));
    }

    @Test
    public void checkFindMaxElement() {
        int maxElement = ArrayUtil.findLimitElement(outerArray, Limit.MAX_ELEMENT);
        Assert.assertTrue(maxElement == 7);
    }

    @Test
    public void checkFindMinElement() {
        int minElement = ArrayUtil.findLimitElement(outerArray, Limit.MIN_ELEMENT);
        Assert.assertTrue(minElement == -10);
    }
}