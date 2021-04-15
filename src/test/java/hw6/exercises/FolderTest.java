package hw6.exercises;

import hw6.AbstractBaseTest;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FolderTest extends AbstractBaseTest {

    @Test
    public void MailFolderTest() {
        // Создаем новое письмо
        actionSteps.createMailLetter();
        // Отправляем письмо
        actionSteps.sendLetter();
        // Сохраняем время отправки
        String sentTime = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());
        // Переходим в папку Отправленные
        actionSteps.goToSent();
        // Verify, что письмо появилось в папке отправленные
        String lastSentLetterTime = actionSteps.getLastSentLetterTime();
        assertionSteps.softAssertLastSentLetterTime(sentTime, lastSentLetterTime);
        // Переходим в папку Тест»
        actionSteps.goToFolderTest();
        // Verify, что письмо появилось в папке «Тест»
        assertionSteps.softAssertLetterInFolderTest();
    }
}
