package hw3.trigonometricOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CosTest extends AbstractBaseTest {
    @Test(dataProvider = "CosDataProvider", dataProviderClass = DataProviderTest.class)
    public void cos(double a, double expectedResult) {
        System.out.println("Косинус числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.cos(a), expectedResult, 0.01, "Ошибка. Результат вычисления не верный");
    }
}
