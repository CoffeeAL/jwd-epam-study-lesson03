package by.epamtc.loiko.lesson03.task01;

import by.epamtc.loiko.lesson03.task02.Limit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class ArrayTest {

    private static int[] sourceArray;
    private static int[] sortedArray;

    @Before
    public void initSourceAndSortedArrays() {
        sourceArray = new int[]{1, 6, 3, -5, 0, 6};
        sortedArray = new int[]{-5, 0, 1, 3, 6, 6};
    }

    @Test
    public void checkBubbleSort() {
        Array sourceArray = new Array(ArrayTest.sourceArray);
        Array targetArray = new Array(ArrayTest.sortedArray);
        sourceArray.bubbleSortArray();
        Assert.assertTrue(sourceArray.equals(targetArray));
    }

    @Test
    public void checkInsertionSort() {
        Array sourceArray = new Array(ArrayTest.sourceArray);
        Array targetArray = new Array(ArrayTest.sortedArray);
        sourceArray.insertionSortArray();
        Assert.assertTrue(sourceArray.equals(targetArray));
    }

    @Test
    public void checkMergeSort() {
        Array sourceArray = new Array(ArrayTest.sourceArray);
        Array targetArray = new Array(ArrayTest.sortedArray);
        sourceArray.mergeSortArray();
        Assert.assertTrue(sourceArray.equals(targetArray));
    }

    @Test
    public void checkBinarySearch() {
        Array sortedArray = new Array(ArrayTest.sortedArray);
        Interval interval = new Interval(0, sortedArray.getCurrentIntArray().length - 1);
        int index = sortedArray.binarySearchElement(interval, 3);
        Assert.assertTrue(index == 3);
    }

    @Test
    public void checkBinarySearchElementNotFound() {
        Array sortedArray = new Array(ArrayTest.sortedArray);
        Interval interval = new Interval(0, sortedArray.getCurrentIntArray().length - 1);
        int index = sortedArray.binarySearchElement(interval, 8);
        Assert.assertTrue(index == -1);
    }

    @Test
    public void checkFindMaxElement() {
        Array array = new Array(ArrayTest.sourceArray);
        int maxElement = array.findLimitElement(Limit.MAX_ELEMENT);
        Assert.assertTrue(maxElement == 6);
    }

    @Test
    public void checkFindMinElement() {
        Array array = new Array(ArrayTest.sourceArray);
        int minElement = array.findLimitElement(Limit.MIN_ELEMENT);
        Assert.assertTrue(minElement == -5);
    }

    @Test
    public void checkFindPrimeNumbers() {
        Array array = new Array(new int[]{1, 6, 3, -5, 0, 6, 5});
        String actualResult = array.findAllPrimeNumbers();
        String estimatedResult = "3 5";
        Assert.assertTrue(actualResult.equals(estimatedResult));
    }

    @Test
    public void checkFindFibonacciNumbers() {
        Array array = new Array(new int[]{1, 6, 3, -5, 0, 6, 5});
        String actualResult = array.findAllFibonacciNumbers();
        String estimatedResult = "1 3 0 5";
        Assert.assertTrue(actualResult.equals(estimatedResult));
    }

    @Test
    public void checkFindThreeDigitDifferentNumbers() {
        Array array = new Array(new int[]{100, 6224, 453, -523, 20, -676, 455});
        String actualResult = array.findAllThreeDifferentDigitNumbers();
        String estimatedResult = "453 -523";
        Assert.assertTrue(actualResult.equals(estimatedResult));
    }

    @Test
    public void checkDefaultConstructor() {
        Array array = new Array();
        Assert.assertTrue(array.getCurrentIntArray().length == 10);
    }

    @Test
    public void checkCustomInitialCapacityConstructor() {
        Array array = new Array(25);
        Assert.assertTrue(array.getCurrentIntArray().length == 25);
    }

    @Test
    public void checkHashCode() {
        int[] sourceArray = {1, 4, 3};
        Array array = new Array(sourceArray);
        Assert.assertTrue(array.hashCode() == 96989);
    }
}