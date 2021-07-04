package by.epamtc.loiko.lesson03.task02;

import by.epamtc.loiko.lesson03.exception.NullArrayException;
import by.epamtc.loiko.lesson03.exception.NullLimitException;
import by.epamtc.loiko.lesson03.exception.NullTypeSortingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class JaggedArrayTest {

    private static int[][] jaggedArray = new int[5][];

    @Before
    public void initJaggedArray() {
        jaggedArray = new int[][]{
                {5, 8, -1},
                {-3, 9},
                {6, -19, 12, 0, 9},
                {12, 18, -34, 3, -23, -2, -5},
                {-5, 2, 21}
        };
    }

    @Test
    public void checkSortBySumElements() throws NullArrayException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortBySumElements(jaggedArray, TypeSorting.ASCENDING);
        int[][] expectedResult = {
                {12, 18, -34, 3, -23, -2, -5}, // -31
                {-3, 9}, // 6
                {6, -19, 12, 0, 9}, // 8
                {5, 8, -1}, // 12
                {-5, 2, 21} // 18
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }

    @Test
    public void checkSortBySumElementsOrderByDescending() throws NullArrayException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortBySumElements(jaggedArray, TypeSorting.DESCENDING);
        int[][] expectedResult = {
                {-5, 2, 21}, // 18
                {5, 8, -1}, // 12
                {6, -19, 12, 0, 9}, // 8
                {-3, 9}, // 6
                {12, 18, -34, 3, -23, -2, -5} // -31
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }

    @Test
    public void checkSortByMaxElement() throws NullArrayException, NullLimitException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortByLimitElements(jaggedArray, Limit.MAX_ELEMENT, TypeSorting.ASCENDING);
        int[][] expectedResult = {
                {5, 8, -1},
                {-3, 9},
                {6, -19, 12, 0, 9},
                {12, 18, -34, 3, -23, -2, -5},
                {-5, 2, 21}
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }

    @Test
    public void checkSortByMaxElementDescending() throws NullArrayException, NullLimitException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortByLimitElements(jaggedArray, Limit.MAX_ELEMENT, TypeSorting.DESCENDING);
        int[][] expectedResult = {
                {-5, 2, 21},
                {12, 18, -34, 3, -23, -2, -5},
                {6, -19, 12, 0, 9},
                {-3, 9},
                {5, 8, -1}
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }

    @Test
    public void checkSortByMinElement() throws NullArrayException, NullLimitException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortByLimitElements(jaggedArray, Limit.MIN_ELEMENT, TypeSorting.ASCENDING);
        int[][] expectedResult = {
                {12, 18, -34, 3, -23, -2, -5},
                {6, -19, 12, 0, 9},
                {-5, 2, 21},
                {-3, 9},
                {5, 8, -1}
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }

    @Test
    public void checkSortByMinElementOrderByDescending() throws NullArrayException, NullLimitException, NullTypeSortingException {
        int[][] actualResult = JaggedArrayRunner.sortByLimitElements(jaggedArray, Limit.MIN_ELEMENT, TypeSorting.DESCENDING);
        int[][] expectedResult = {
                {5, 8, -1},
                {-3, 9},
                {-5, 2, 21},
                {6, -19, 12, 0, 9},
                {12, 18, -34, 3, -23, -2, -5},
        };
        Assert.assertTrue(Arrays.deepEquals(actualResult, expectedResult));
    }
}