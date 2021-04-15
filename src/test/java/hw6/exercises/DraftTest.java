package hw6.exercises;

import hw6.AbstractBaseTest;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DraftTest extends AbstractBaseTest {

    @Test
    public void MailDraftTest(){
        // Создаем новое письмо
        actionSteps.createMailLetter();
        // Сохраняем как черновик
        actionSteps.saveLetterDraft();
        // Создаем переменную, в которую сохраняем количество черновиков
        int draftsCount = actionSteps.getDraftCount();
        // Открываем первое письмо и сверяем контент
        assertionSteps.assertFieldLetter();
        // Отправляем черновик и сохраняем время отправки
        actionSteps.sendLetter();
        String sentTime = new SimpleDateFormat("H:mm").format(Calendar.getInstance().getTime());
        // Сохраняем количество оставшихся черновиков и проверяем, что письмо исчезло из черновиков
        int draftsCountAfterSending = actionSteps.getDraftCount();
        assertionSteps.assertLetterIsSent(draftsCount, draftsCountAfterSending);
        // В папке отправленные сохраняем время отправки последнего письма
        String lastSentLetterTime = actionSteps.getLastSentLetterTime();
        assertionSteps.assertLastSentLetterTime(sentTime, lastSentLetterTime);
    }
}
