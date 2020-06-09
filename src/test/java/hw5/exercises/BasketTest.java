package hw5.exercises;

import hw5.AbstractBaseTest;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.testng.Assert.assertEquals;

public class BasketTest extends AbstractBaseTest {

    @Test
    public void MailBasketTest() {
        // Создаем переменную: количество входящих писем до отправки письма
        int beforeSendingLetter = foldersPage.getMailsCount();
        // Нажимаем на кнопку Написать письмо
        foldersPage.clickWriteLetterButton();
        // Заполняем поля
        letterPage.createLetter(address, titleForBasket, body);
        // Отправляем письмо и закрываем окно
        letterPage.clickSendLetter();
        letterPage.clickCloseSentLetter();
        // Создаем переменную: количество входящих писем после отправки письма
        int afterSendingLetter = foldersPage.getMailsCount();
        // Провереяем, что после отправки письма во входящих появилось еще одно
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(beforeSendingLetter + 1, afterSendingLetter, "Письмо не появилось в папке Входящие");
        softAssert.assertAll();
        // Запоминаем время входящего письма
        String inboxTimeLetter = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());
        // Наводим на чексбокс первого письма и кликаем на него
        Actions builder = new Actions(driver);
        builder.moveToElement(foldersPage.checkboxFirstLetter()).click();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        // Удаляем письмо, переходим в папку Корзина
        foldersPage.deleteLetterInbox();
        foldersPage.goToTrash();
        // Проверяем, что письмо появилось в папке Корзина (по времени)
        String lastDelLetterTime = letterPage.getLastSentLetterTime();
        // Сверяем время удаления письма
        assertEquals(lastDelLetterTime, inboxTimeLetter);
    }
}
