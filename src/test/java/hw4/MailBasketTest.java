package hw4;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import static org.testng.Assert.assertEquals;

public class MailBasketTest extends AbstractBaseTest {
    String address = "qa_kva@mail.ru";
    String title = "В корзину";
    String body = "Письмо нужно отправить в корзину";

    @Test
    public void MailBasketTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Создаем переменную: количество входящих писем до отправки письма
       int beforeSendingLetter = getMailsCount(wait);

        // Создание нового письма (заполняем адресата, тему письма и тело)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".compose-button__wrapper"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--zU301 input"))).sendKeys(address);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".container--3QXHv input"))).sendKeys(title);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='textbox']"))).sendKeys(body);

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Отправить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Закрыть\"]"))).click();

        // Ждем, пока письмо отправится
        Sleep(5000);

        SoftAssert softAssert = new SoftAssert();
        // Создаем переменную: количество входящих писем после отправки письма
        int afterSendingLetter = getMailsCount(wait);
        // Провереяем, что после отправки письма во входящих появилось еще одно
        softAssert.assertEquals(beforeSendingLetter + 1, afterSendingLetter, "Письмо не появилось в папке Входящие");
        softAssert.assertAll();

        // Запоминаем время входящего письма
        String inboxTimeLetter = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());

        // Наводим на чексбокс первого письма и кликаем на него
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//span[@class='ll-av__checkbox']")))
                .click();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();

        // Удаляем письмо, переходим в папку Корзина
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[title=\"Удалить\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'Корзина')]"))).click();

        // Проверяем, что письмо появилось в папке Корзина (по времени)
        String lastDelLetterTime = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".llc__item.llc__item_date"))).getText();
        // Сверяем время удаления письма
        assertEquals(lastDelLetterTime, inboxTimeLetter);
    }

    // Считаем количество писем в папке Входящие
    private int getMailsCount(WebDriverWait wait) {
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".js-letter-list-item"))).size();
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".octopus__title")));
            return 0;
        }
    }
}