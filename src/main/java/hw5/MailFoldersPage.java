package hw5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MailFoldersPage extends BasePage {
    public MailFoldersPage(WebDriver driver) {
        super(driver);
    }
    // Кнопка "написать письмо"
    @FindBy(xpath  = "//span[@class='compose-button__wrapper']")
    private WebElement writeLetterBtn;
    // Папка Входящие
    @FindBy(xpath  = "//a[@href='/inbox/']")
    private WebElement inboxFolder;
    // Папка Тест
    @FindBy(xpath  = "//a[@href='/1/']")
    private WebElement testFolder;
    // Папка Отправленные
    @FindBy(xpath  = "//a[@href='/sent/']")
    private WebElement sentFolder;

    // Папка Черновики
    @FindBy(xpath  = "//a[@href='/drafts/']")
    private WebElement draftFolder;
    // Первое письмо в черновиках
    @FindBy(xpath  = "//a[contains(@href,'/drafts/0:')]")
    private WebElement firstDraftLetter;
    // Всего черновиков в папке
    @FindBy(className = "js-letter-list-item")
    private List<WebElement> allDraftLetters;
    // Всего писем в папке Входящие
    @FindBy(className = "js-letter-list-item")
    private List<WebElement> allMailsLetters;
    // Чекбокс первого письма во входящих
    @FindBy(xpath  = "//span[@class='ll-av__checkbox']")
    public WebElement checkboxFirstLetter;
    // Кнопка удалить во входящих
    @FindBy(xpath  = "//span[@title='Удалить']")
    private WebElement deleteButton;
    // Папка Корзина
    @FindBy(xpath  = "//a[@href='/trash/']")
    private WebElement trashFolder;

    // Нажимаем на кнопку Написать письмо
    public void clickWriteLetterButton() {
        writeLetterBtn.click();
    }
    // В папку Черновики
    public void goToDrafts() {
        draftFolder.click();
    }
    // Сохраняем общее кол-во черновиков
    public int getDraftsCount() {
        return allDraftLetters.size();
    }
    // Открываем первое письмо из черновиков
    public void goToFirstDraftLetter() {
        firstDraftLetter.click();
    }
    // В папку Отправленные
    public void goToSent() {
        sentFolder.click();
    }
    // В папку Входящие
    public void goToInbox() {
        inboxFolder.click();
    }
    // В папку Тест
    public void goToTest() {
        testFolder.click();
    }
    // Чекбокс первого письма во входящих
    public WebElement checkboxFirstLetter() {
        return checkboxFirstLetter;
    }
    // Удалить входящее письмо
    public void deleteLetterInbox() {
        deleteButton.click();
    }
    // В папку Корзина
    public void goToTrash() {
        trashFolder.click();
    }
    // Считаем количество писем в папке Входящие
    public int getMailsCount() {
        try {
            return allMailsLetters.size();
        } catch (Exception e) {
            driver.findElement(By.className("octopus__title"));
            return 0;
        }
    }
}
