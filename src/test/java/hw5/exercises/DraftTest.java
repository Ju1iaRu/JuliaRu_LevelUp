package hw5.exercises;

import hw5.AbstractBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static org.testng.Assert.assertEquals;

public class DraftTest extends AbstractBaseTest {

    @Test
    public void MailDraftTest(){
        // Нажимаем на кнопку Написать письмо
        foldersPage.clickWriteLetterButton();
        // Заполняем поля
        letterPage.createLetter(address, title, body);
        // Сохраняем как черновик и закрываем окно
        letterPage.clickSaveLetter();
        letterPage.clickCloseLetter();
        // Переходим в папку черновики
        foldersPage.goToDrafts();
        // Создаем переменную, в которую сохраняем количество черновиков
        int draftsCount = foldersPage.getDraftsCount();

        // Открываем первое письмо и сверяем контент
        foldersPage.goToFirstDraftLetter();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(letterPage.getAddressee(), address, "Адресат не корректен");
        softAssert.assertEquals(letterPage.getTitleOfLetter(), title, "Тема письма не корректна");
        softAssert.assertEquals(letterPage.getBodyOfLetter(), "Привет\n\nПОДПИСЬ", "Тело письма не совпадает");

        // Отправляем черновик и сохраняем время отправки
        letterPage.clickSendLetter();
        letterPage.clickCloseSentLetter();
        String sentTime = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());

        // Сохраняем количество оставшихся черновиков и проверяем, что письмо исчезло из черновиков
        int draftsCountAfterSending;
        try {
            driver.findElement(By.className("octopus__title"));
             draftsCountAfterSending = 0;
        } catch(Exception e) {
            draftsCountAfterSending = foldersPage.getDraftsCount();
        }
        softAssert.assertEquals(draftsCount - 1, draftsCountAfterSending, "Письмо не исчезло из черновиков");
        softAssert.assertAll();

        // В папке отправленные сохраняем время отправки последнего письма
        foldersPage.goToSent();
        String lastSentLetterTime = letterPage.getLastSentLetterTime();
        assertEquals(lastSentLetterTime, sentTime);
    }
}
