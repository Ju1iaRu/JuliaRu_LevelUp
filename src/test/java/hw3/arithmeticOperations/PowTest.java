package hw3.arithmeticOperations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PowTest extends AbstractBaseTest {

    @Test(dataProvider = "PowDataProviderDouble", dataProviderClass = DataProviderTest.class)
    public void pow(double a, double b, double expectedResult) {
        System.out.println("Возведение в степень: " + a + " ^ " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.pow(a,b), expectedResult, "Ошибка. Результат вычисления не верный");
    }

}
