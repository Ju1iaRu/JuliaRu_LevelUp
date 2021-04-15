package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends AbstractBaseTest {

    @Test(dataProvider = "DivDataProviderLong", dataProviderClass = DataProviderTest.class)
    public void div (long a, long b,  long expectedResult) {
        System.out.println("Деление чисел: " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.div(a,b), expectedResult, "Ошибка. Результат вычисления не верный");
    }

    @Test(dataProvider = "DivDataProviderDouble", dataProviderClass = DataProviderTest.class)
    public void div(double a, double b, double expectedResult) {
        System.out.println("Деление чисел: " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.div(a,b), expectedResult, 0.01, "Ошибка. Результат вычисления не верный");
    }
}
