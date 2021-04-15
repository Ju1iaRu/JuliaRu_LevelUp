package hw6.steps;

import hw5.LetterPage;
import hw5.MailFoldersPage;
import hw5.MailLoginPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {
    protected WebDriver driver;
    MailLoginPage loginPage;
    MailFoldersPage foldersPage;
    LetterPage letterPage;

    protected static final String username = "qa_kva@mail.ru";
    protected static final String password = "zaqxsw_123";
    protected static final String address = "test@mail.ru";
    protected static final String title = "Тест";
    protected static final String titleForBasket = "Hello";
    protected static final String body = "Привет";

    protected AbstractBaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new MailLoginPage(driver);
        foldersPage = new MailFoldersPage(driver);
        letterPage = new LetterPage(driver);
    }
}

