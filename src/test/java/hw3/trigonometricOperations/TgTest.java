package hw3.trigonometricOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TgTest extends AbstractBaseTest {

    @Test(dataProvider = "TgDataProvider", dataProviderClass = DataProviderTest.class)
    public void tg(double a, double expectedResult) {
        System.out.println("Тангенс числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.tg(a), expectedResult,0.01, "Ошибка. Результат вычисления не верный");
    }

}
