package Pages;

import helper.GUIActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static helper.GUIActions.*;

public class CreateNewAccount {
    private final WebDriver driver ;
    private final GUIActions guiActions;
    public CreateNewAccount(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }
    private final By submitElement = By.id("SubmitCreate");
    private final By loginElement = By.cssSelector("a.login");
    private final By rigesteredBefore = By.tagName("h3");
    public By alertMessage = By.xpath("//*[@id=\"create_account_error\"]/ol/li");
    private final By createacountElement = By.id("email_create");

    public RegisterPage create(String email)   {
        clickButton(loginElement);
        setText(createacountElement, email);
        clickButton(submitElement);
        return new RegisterPage(driver);
    }
    public String rigesteredBeforeOrNot() throws InterruptedException {
        Thread. sleep(2000);
        return getText(rigesteredBefore);
    }
}
