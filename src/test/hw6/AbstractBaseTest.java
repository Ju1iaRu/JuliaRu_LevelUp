package hw6;

import hw6.steps.ActionSteps;
import hw6.steps.AssertionSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }

    @BeforeMethod
    public void logIn() {
        actionSteps.logIn();
        assertionSteps.assertLogIn();
    }

    @AfterMethod
    public void LogOut() {
        actionSteps.logOut();
        driver.quit();
    }
}
