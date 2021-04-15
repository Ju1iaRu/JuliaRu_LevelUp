package hw3.trigonometricOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SinTest extends AbstractBaseTest {

    @Test(dataProvider = "SinDataProvider", dataProviderClass = DataProviderTest.class)
    public void sin(double a, double expectedResult) {
        System.out.println("Синус числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.sin(a), expectedResult, 0.01, "Ошибка. Результат вычисления не верный");
    }
}
