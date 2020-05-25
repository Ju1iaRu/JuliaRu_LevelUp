package hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class MailFolderTest extends AbstractBaseTest {
    String address = "qa_kva@mail.ru";
    String title = "Тест";
    String body = "Привет";

    @Test
    public void MailFolderTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Создание нового письма (заполняем адресата, тему письма и тело)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__wrapper"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--zU301 input"))).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--3QXHv input"))).sendKeys(title);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).sendKeys(body);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Отправить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Закрыть\"]"))).click();

        // Переходим в папку отправленные
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/sent/\"]"))).click();

        // Сверяем отправителя и тело письма
        SoftAssert softAssert = new SoftAssert();
        String addressee = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ll-crpt']"))).getText();
        String bodyOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ll-sp__normal']"))).getText();

        softAssert.assertEquals(addressee, address, "Адресат не совпадает");
        softAssert.assertEquals(bodyOfLetter, body, "Тело письма не совпадает");

        // Переходим в папку Тест и сверяем тему письма
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav__folder-badge"))).click();
        String titleOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ll-sj__normal']"))).getText();
        softAssert.assertEquals(titleOfLetter, "Self: Тест", "Тема письма не совпадает");
        softAssert.assertAll();
    }
}
