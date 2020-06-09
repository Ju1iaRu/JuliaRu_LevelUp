package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractBaseTest {

   protected WebDriver driver;
   protected static final String username = "test@mail.ru";
   protected static final String password = "123456";
   protected static final String address = "test@mail.ru";
   protected static final String title = "Тест";
   protected static final String titleForBasket = "Hello";
   protected static final String body = "Привет";
   protected MailLoginPage loginPage;
   protected MailFoldersPage foldersPage;
   protected LetterPage letterPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new MailLoginPage(driver);
        foldersPage = new MailFoldersPage(driver);
        letterPage = new LetterPage(driver);
    }

    @BeforeMethod
    public void logIn() {
        driver.get("https://mail.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.logIn(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Входящие"));
        Assert.assertTrue(driver.getTitle().contains("Входящие"),  "Авторизация не пройдена");
    }

    @AfterMethod
    public void LogOut() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title=\"выход\"]"))).click();
         driver.quit();
    }
}

