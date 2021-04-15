package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends BasePage {
    public LetterPage(WebDriver driver) {
        super(driver);
    }
    // Поле "Кому"
    @FindBy(xpath = "//div[@data-name='to']//input[@type='text']")
    private WebElement addressField;
    // Заполненное поле Кому
    @FindBy(xpath = "//span[@class='text--1tHKB']")
    private WebElement addresseeField;
    // Поле Тема
    @FindBy(name = "Subject")
    private WebElement titleField;
    // Тело письма
    @FindBy(xpath  = "//div[@role='textbox']")
    private WebElement bodyField;
    // Кнопка Сохранить
    @FindBy(xpath  = "//span[@title='Сохранить']")
    private WebElement saveLetter;
    // Кнопка Отправить
    @FindBy(xpath  = "//span[@title='Отправить']")
    private WebElement sendLetter;
    // Закрыть окно
    @FindBy(xpath = "//button[@title='Закрыть']")
    private WebElement closeLetter;
    // Закрыть окно после отправки письма
    @FindBy(xpath = "//span[@title='Закрыть']")
    private WebElement closeSentLetter;
    // Время отправки
    @FindBy(xpath = "//div[contains(@title,'Сегодня')]")
    private WebElement lastSentLetterTime;

    // Заполняем поля в письме
    public void createLetter(String address, String title, String body) {
        addressField.sendKeys(address);
        titleField.sendKeys(title);
        bodyField.sendKeys(body);
    }
    // Нажимаем на кнопку Сохранить
    public void clickSaveLetter() {
        saveLetter.click();
    }
    // Закрываем окно с письмом
    public void clickCloseLetter() {
        closeLetter.click();
    }
    // Нажимаем на кнопку Отправить
    public void clickSendLetter() {
        sendLetter.click();
    }
    // Закрываем письмо после отправки
    public void clickCloseSentLetter() {
        closeSentLetter.click();
    }
    // Адресат письма
    public String getAddressee() {
        String addressee = addresseeField.getText();
        return addressee;
    }
    // Тема письма
    public String getTitleOfLetter() {
        String titleOfLetter = titleField.getAttribute("value");
        return titleOfLetter;
    }
    // Содержимое письма
    public String getBodyOfLetter() {
        String bodyOfLetter = bodyField.getText();
        return bodyOfLetter;
    }
    // Сохраняем время отправки последнего письма
    public String getLastSentLetterTime() {
        return lastSentLetterTime.getText();
    }
}


