package hw3.trigonometricOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CtgTest extends AbstractBaseTest {
    @Test(dataProvider = "CtgDataProvider", dataProviderClass = DataProviderTest.class)
    public void ctg(double a, double expectedResult) {
        System.out.println("Котангенс числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.ctg(a), expectedResult, 0.01, "Ошибка. Результат вычисления не верный");
    }
}
