package hw3.positive_negative_Operations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest extends AbstractBaseTest {

    @Test(dataProvider = "PositiveDataProvider", dataProviderClass = DataProviderTest.class)
    public void isPositive(long a, boolean expectedResult) {
        System.out.println("Является ли число положительным: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.isPositive(a), expectedResult);
    }
}
