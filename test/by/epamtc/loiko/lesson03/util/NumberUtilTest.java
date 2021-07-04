package by.epamtc.loiko.lesson03.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alexey Loiko
 * @project jwd-epam-study-lesson03
 */
public class NumberUtilTest {

    @Test
    public void checkIsPrimeNumber() {
        Assert.assertTrue(NumberUtil.isPrimeNumber(5));
    }

    @Test
    public void checkNegativeNumberForPrimeNumber() {
        Assert.assertFalse(NumberUtil.isPrimeNumber(-3));
    }

    @Test
    public void checkIsNotPrimeNumber() {
        Assert.assertFalse(NumberUtil.isPrimeNumber(4));
    }

    @Test
    public void checkIsFibonacciNumber() {
        Assert.assertTrue(NumberUtil.isFibonacciNumber(3));
    }

    @Test
    public void checkZeroForFibonacci() {
        Assert.assertTrue(NumberUtil.isFibonacciNumber(0));
    }

    @Test
    public void checkNegativeNumberForFibonacci() {
        Assert.assertFalse(NumberUtil.isFibonacciNumber(-1));
    }

    @Test
    public void checkIsNotFibonacciNumber() {
        Assert.assertTrue(!NumberUtil.isFibonacciNumber(10));
    }

    @Test
    public void checkHasThreeDifferentDigitsInThreeDigitNumber() {
        Assert.assertTrue(NumberUtil.hasDifferentDigitsThreeDigitNumber(123));
    }

    @Test
    public void checkHasSameDigitsInThreeDigitNumber() {
        Assert.assertFalse(NumberUtil.hasDifferentDigitsThreeDigitNumber(101));
    }

    @Test
    public void checkNotThreeDigitNumber() {
        Assert.assertFalse(NumberUtil.hasDifferentDigitsThreeDigitNumber(50));
    }
}