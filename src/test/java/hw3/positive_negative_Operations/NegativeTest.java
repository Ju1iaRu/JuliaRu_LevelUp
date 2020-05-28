package hw3.positive_negative_Operations;

import hw3.AbstractBaseTest;
import hw3.DataProviderTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends AbstractBaseTest {

    @Test(dataProvider = "NegativeDataProvider", dataProviderClass = DataProviderTest.class)
    public void isNegative(long a, boolean expectedResult) {
        System.out.println("Является ли число отрицательным: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.isNegative(a), expectedResult);
    }
}
