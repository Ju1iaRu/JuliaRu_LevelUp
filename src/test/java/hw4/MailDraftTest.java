package hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;

public class MailDraftTest extends AbstractBaseTest {
    String address = "test@mail.ru";
    String title = "test";
    String body = "Привет";

    @Test
    public void MailDraftTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Создание нового письма (заполняем адресата, тему письма и тело)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__wrapper"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--zU301 input"))).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--3QXHv input"))).sendKeys(title);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).sendKeys(body);

        // Сохраняем письмо в черновиках
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-title-shortcut=\"Ctrl+S\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[title=\"Закрыть\"]"))).click();

        // Переходим в папку черновики
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/drafts/\"]"))).click();

        // Создаем переменную, в которую сохраняем количество черновиков
        int draftsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".js-letter-list-item"))).size();

        // Открываем первое письмо и сверяем контент
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^=\"/drafts/0:\"]"))).click();

        SoftAssert softAssert = new SoftAssert();
        String addressee = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".text--1tHKB"))).getText();
        String titleOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Subject']"))).getAttribute("value");
        String bodyOfLetter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).getText();

        softAssert.assertEquals(addressee, address, "Адресат не корректен");
        softAssert.assertEquals(titleOfLetter, title, "Тема письма не корректна");
        softAssert.assertEquals(bodyOfLetter, "Привет\n\nПОДПИСЬ", "Тело письма не совпадает");

        // Отправляем черновик и сохраняем время отправки
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Отправить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Закрыть\"]"))).click();
        String sentTime = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());

        // Сохраняем количество оставшихся черновиков и проверяем, что письмо исчезло из черновиков
        int draftsCountAfterSending;
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".octopus__title")));
            draftsCountAfterSending = 0;
        } catch(Exception e) {
            draftsCountAfterSending = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".js-letter-list-item"))).size();
        }
        softAssert.assertEquals(draftsCount - 1, draftsCountAfterSending, "Письмо не исчезло из черновиков");
        softAssert.assertAll();

        // В папке отправленные сохраняем время отправки последнего письма
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href=\"/sent/\"]"))).click();
        String lastSentLetterTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".llc__item.llc__item_date"))).getText();
        // Сверяем время отправки письма
        assertEquals(lastSentLetterTime, sentTime);

    }
}