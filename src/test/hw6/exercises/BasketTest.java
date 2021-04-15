package hw6.exercises;

import hw6.AbstractBaseTest;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BasketTest extends AbstractBaseTest {

    @Test
    public void MailBasketTest() {
        // Создаем переменную: количество входящих писем до отправки письма
        int beforeSendingLetter = actionSteps.getAllInboxLetters();
        // Создаем новое письмо
        actionSteps.createMailLetter();
        // Отправляем письмо
        actionSteps.sendLetter();
        // Создаем переменную: количество входящих писем после отправки письма
        int afterSendingLetter = actionSteps.getAllInboxLetters();
        // Провереяем, что после отправки письма во входящих появилось еще одно
        assertionSteps.softAssertLetterInInboxFolder(beforeSendingLetter, afterSendingLetter);
        // Запоминаем время входящего письма
        String inboxTimeLetter = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());
        // Наводим на чексбокс первого письма и кликаем на него
        actionSteps.clickToCheckboxFirstLetter();
        // Удаляем письмо, переходим в папку Корзина
       actionSteps.delLetterInInbox();
        // Проверяем, что письмо появилось в папке Корзина (по времени)
        String lastDelLetterTime = actionSteps.getLastSentLetterTime();
        // Сверяем время удаления письма
        assertionSteps.assertLastSentLetterTime(lastDelLetterTime, inboxTimeLetter);
    }
}
