package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SentLettersPage {
    private WebDriver driver;

    public SentLettersPage(WebDriver driver) {
        this.driver = driver;
    }
    // Сохраняем время отправки последнего письма
    public String getLastSentLetterTime() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".llc__item.llc__item_date"))).getText();
    }


}