package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {

    public WebDriver driver;

    @BeforeMethod
    public void logIn() {

        String login = "test@mail.ru";
        String password = "123456";

        By usernameLocator = By.id("mailbox:login");
        By passwordButtonLocator = By.id("mailbox:submit");
        By passwordLocator = By.id("mailbox:password");
        By loginButtonLocator = By.id("mailbox:submit");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usernameLocator)).sendKeys(login);
        wait.until(ExpectedConditions.elementToBeClickable(passwordButtonLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();

        wait.until(ExpectedConditions.titleContains("Входящие"));
        Assert.assertTrue(driver.getTitle().contains("Входящие"),  "Авторизация не пройдена");
        }


    @AfterMethod
    public void LogOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"выход\"]"))).click();
        driver.quit();
    }

    public void Sleep(int millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}