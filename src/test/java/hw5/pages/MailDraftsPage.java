package hw5.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MailDraftsPage {
    private WebDriver driver;

    public MailDraftsPage(WebDriver driver) {
        this.driver = driver;
    }
    // Открываем первое письмо
    public MailDraftsPage openDraft() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^=\"/drafts/0:\"]"))).click();
        return this;
    }
    // Сохраняем адресата, название письма и тело
    public String getAddressee() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String addressee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text--1tHKB"))).getText();
        return addressee;
    }
    public String getTitleOfLetter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String titleOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Subject']"))).getAttribute("value");
        return titleOfLetter;
    }
    public String getBodyOfLetter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String bodyOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).getText();
        return bodyOfLetter;
    }
    // Отправляем открытый черновик
    public MailDraftsPage sendOpenedDraft() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Отправить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Закрыть\"]"))).click();
        return this;
    }
    // Сохраняем количество оставшихся черновиков
    public int getDraftsCount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".js-letter-list-item"))).size();
    }
    // Переходим в папку отправленные
    public SentLettersPage goToSentLetters() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/sent/\"]"))).click();
        return new SentLettersPage(driver);
    }


}
