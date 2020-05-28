package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends AbstractBaseTest {

    @Test(dataProvider = "SubDataProviderLong", dataProviderClass = DataProviderTest.class)
    public void sub(long a, long b, long expectedResult) {
        System.out.println("Вычитание чисел: " + a + "-" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sub(a,b), expectedResult,"Ошибка. Результат вычисления не верный");
    }

    @Test(dataProvider = "SubDataProviderDouble", dataProviderClass = DataProviderTest.class)
    public void sub(double a, double b, double expectedResult) {
        System.out.println("Вычитание чисел: " + a + "-" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sub(a,b), expectedResult, "Ошибка. Результат вычисления не верный");
    }
}
