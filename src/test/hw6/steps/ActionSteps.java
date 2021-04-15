package hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActionSteps extends AbstractBaseStep {
    public ActionSteps(WebDriver driver) {
        super(driver);
    }
    @Step("Авторизация")
    public void logIn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.logIn(username, password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Входящие"));
    }
    @Step("Написать письмо")
    public void createMailLetter() {
        foldersPage.clickWriteLetterButton();
        letterPage.createLetter(address, title, body);
    }
    @Step("Сохраняем письмо в черновиках")
    public void saveLetterDraft(){
        letterPage.clickSaveLetter();
        letterPage.clickCloseLetter();
        foldersPage.goToDrafts();
    }
    @Step("Получаем количество писем в черновиках")
    public int getDraftCount(){
        try {
            driver.findElement(By.className("octopus__title"));
            return 0;
        } catch(Exception e) {
           return foldersPage.getDraftsCount();
        }
    }
    @Step("Получаем время последнего отправленного письма")
    public String getLastSentLetterTime(){
        return letterPage.getLastSentLetterTime();
    }
    @Step("Отправка письма")
    public void sendLetter(){
        letterPage.clickSendLetter();
        letterPage.clickCloseSentLetter();
    }
    @Step("Переход в папку Отправленные")
    public void goToSent() {
        foldersPage.goToSent();
    }
    @Step("Переход в папку Тест")
    public void goToFolderTest() {
        foldersPage.goToTest();
    }
    @Step("Получаем количество входящих писем до отправки письма")
    public int getAllInboxLetters(){
        return foldersPage.getMailsCount();
    }
    @Step("Наводим на чексбокс первого письма и кликаем на него")
    public void clickToCheckboxFirstLetter() {
        Actions builder = new Actions(driver);
        builder.moveToElement(foldersPage.checkboxFirstLetter()).click();
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }
    @Step("Удаляем письмо, переходим в папку Корзина")
    public void delLetterInInbox() {
        foldersPage.deleteLetterInbox();
        foldersPage.goToTrash();
    }
    @Step("Выход из почты")
    public void logOut(){
        loginPage.logOut();
    }
}
