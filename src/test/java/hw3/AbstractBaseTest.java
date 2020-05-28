package hw3;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractBaseTest {

    public static Calculator calculator;

    @BeforeSuite
    public void setUpCalculator() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDownCalculator() {
        calculator = null;
    }
}