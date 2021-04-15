package hw6.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertionSteps extends AbstractBaseStep {
    public AssertionSteps(WebDriver driver) {
        super(driver);
    }
    SoftAssert softAssert = new SoftAssert();

    @Step("Проверка успешной авторизации")
    public void assertLogIn() {
        Assert.assertTrue(driver.getTitle().contains("Входящие"), "Авторизация не пройдена");
    }
    @Step("Проверка контента письма")
    public void assertFieldLetter() {
        foldersPage.goToFirstDraftLetter();
        softAssert.assertEquals(letterPage.getAddressee(), address, "Адресат не корректен");
        softAssert.assertEquals(letterPage.getTitleOfLetter(), title, "Тема письма не корректна");
        softAssert.assertEquals(letterPage.getBodyOfLetter(), "Привет\n\nПОДПИСЬ", "Тело письма не совпадает");
        softAssert.assertAll();
    }
    @Step("Проверка, что письмо исчезло из черновиков")
    public void assertLetterIsSent(int draftsBeforeSending, int draftsAfterSending){
        softAssert.assertEquals(draftsBeforeSending - 1, draftsAfterSending, "Письмо не исчезло из черновиков");
        softAssert.assertAll();
    }
    @Step("Проверка, что время отправленного письма совпало с временем отправленного письма")
    public void assertLastSentLetterTime(String sendingTime, String lastLetterSendingTime){
        Assert.assertEquals(lastLetterSendingTime, sendingTime);
    }
    @Step("Проверка, что письмо появилось в папке отправленные")
    public void softAssertLastSentLetterTime(String sendingTime, String lastLetterSendingTime) {
        softAssert.assertEquals(lastLetterSendingTime, sendingTime);
        softAssert.assertAll();
    }
    @Step("Проверка, что письмо появилось в папке Тест")
    public void softAssertLetterInFolderTest() {
        softAssert.assertEquals(letterPage.getTitleOfLetter(), title, "Тема письма не корректна");
        softAssert.assertAll();
    }
    @Step("Проверка, что после отправки письма во входящих появилось еще одно")
    public void softAssertLetterInInboxFolder(int beforeSendingLetter, int afterSendingLetter) {
        softAssert.assertEquals(beforeSendingLetter + 1, afterSendingLetter, "Письмо не появилось в папке Входящие");
        softAssert.assertAll();
    }
}
