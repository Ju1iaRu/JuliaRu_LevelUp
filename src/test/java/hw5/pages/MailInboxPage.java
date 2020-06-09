package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MailInboxPage {
    private WebDriver driver;

    public MailInboxPage(WebDriver driver) {
        this.driver = driver;
    }
    // Создание нового письма (заполняем адресата, тему письма и тело)
    public MailInboxPage createNewMailLetterDraft(String address, String title, String body) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__wrapper"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--zU301 input"))).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--3QXHv input"))).sendKeys(title);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).sendKeys(body);
        // Сохраняем письмо в черновики
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-title-shortcut=\"Ctrl+S\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title=\"Закрыть\"]"))).click();
        return this;
    }

    // Переходим в папку черновики
    public MailDraftsPage goToDrafts() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/drafts/\"]"))).click();
        return new MailDraftsPage(driver);
    }


    public String getTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__wrapper")));
        return driver.getTitle();
    }

    // 2 задание

    // Отправляем письмо
    public MailInboxPage sendOpenedLetter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Отправить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Закрыть\"]"))).click();
        return this;
    }
    //
    // public MailInboxPage goToSentLetters2() {
    // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/sent/\"]"))).click();
    //   return SentLetters;


    // }
}