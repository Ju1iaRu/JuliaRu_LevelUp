package hw5.exercises;

import hw6.AbstractBaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FolderTest extends AbstractBaseTest {

    @Test
    public void MailFolderTest() {
        // Нажимаем на кнопку Написать письмо
        foldersPage.clickWriteLetterButton();
        // Заполняем поля
        letterPage.createLetter(address, title, body);
        // Отправить письмо и закрыть окно
        letterPage.clickSendLetter();
        letterPage.clickCloseSentLetter();
        // Сохраняем время отправки
        String sentTime = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());
        // Verify, что письмо появилось в папке отправленные
        foldersPage.goToSent();
        SoftAssert softAssert = new SoftAssert();
        String lastSentLetterTime = letterPage.getLastSentLetterTime();
        softAssert.assertEquals(lastSentLetterTime, sentTime);
        // Verify, что письмо появилось в папке «Тест»
        foldersPage.goToTest();
        softAssert.assertEquals(letterPage.getTitleOfLetter(), title, "Тема письма не корректна");
        softAssert.assertAll();
    }

}
