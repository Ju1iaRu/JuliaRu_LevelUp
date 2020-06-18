package hw5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailLoginPage extends BasePage {

    public MailLoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (id = "mailbox:login")
            private WebElement usernameLocator;
    @FindBy (id = "mailbox:submit")
            private WebElement passwordButton;
    @FindBy (id = "mailbox:password")
            private WebElement passwordLocator;
    @FindBy (id = "mailbox:submit")
            private WebElement loginButton;
    @FindBy (xpath = "//a[@title='выход']")
            private WebElement logOutButton;

    // Авторизация на почте
    public MailFoldersPage logIn(String username, String password) {
        usernameLocator.sendKeys(username);
        passwordButton.click();
        passwordLocator.sendKeys(password);
        loginButton.click();

        return new MailFoldersPage(driver);
    }
    // Выход из почты
    public void logOut(){
        logOutButton.click();
    }
}
