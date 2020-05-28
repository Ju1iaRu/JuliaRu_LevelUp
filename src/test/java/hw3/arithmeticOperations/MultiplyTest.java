package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplyTest extends AbstractBaseTest {

    @Test(dataProvider = "MultDataProviderLong", dataProviderClass = DataProviderTest.class)
    public void mult(long a, long b, long expectedResult) {
        System.out.println("Умножение чисел: " + a + "*" + b + " = " + expectedResult);
        Assert.assertEquals(calculator.mult(a, b), expectedResult, "Ошибка. Результат вычисления не верный");
    }
    @Test(dataProvider = "MultiDataProviderDouble", dataProviderClass = DataProviderTest.class)
    public void mult(double a, double b, double expectedResult) {
        System.out.println("Умножение чисел: : " + a + " * " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.mult(a,b), Math.floor(expectedResult), "Ошибка. Результат вычисления не верный");
    }
}