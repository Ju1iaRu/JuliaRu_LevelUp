package hw5.pages;

import hw5.pages.MailInboxPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

// Авторизация на почте
public class MailLoginPage {
    By usernameLocator = By.id("mailbox:login");
    By passwordButtonLocator = By.id("mailbox:submit");
    By passwordLocator = By.id("mailbox:password");
    By loginButtonLocator = By.id("mailbox:submit");

    private WebDriver driver;

    public MailLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public MailInboxPage logIn(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(usernameLocator)).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(passwordButtonLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(passwordLocator)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator)).click();

        return new MailInboxPage(driver);
    }
}
