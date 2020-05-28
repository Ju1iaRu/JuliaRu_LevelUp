package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends AbstractBaseTest {

    @Test(dataProvider = "SqrtDataProvider", dataProviderClass = DataProviderTest.class)
    public void sqrt(double a, double expectedResult) {
        System.out.println("Вычисление квадратного корня: " + a + " = " + expectedResult);
        Assert.assertEquals(calculator.sqrt(a), expectedResult,"Ошибка. Результат вычисления не верный");
    }
}
