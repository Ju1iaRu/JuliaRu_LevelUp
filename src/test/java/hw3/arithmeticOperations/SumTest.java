package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SumTest extends AbstractBaseTest {

    @Test(dataProvider = "SumDataProviderLong", dataProviderClass = DataProviderTest.class)
    public void sum(long a, long b, long expectedResult) {
        System.out.println("Сумма чисел: " + a + "+" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sum(a,b), expectedResult,"Ошибка. Результат вычисления не верный");
    }

    @Test(dataProvider = "SumDataProviderDouble", dataProviderClass = DataProviderTest.class)
    public void sum(double a, double b, double expectedResult) {
        System.out.println("Сумма чисел: " + a + "+" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sum(a,b), expectedResult, "Ошибка. Результат вычисления не верный");
    }
}
