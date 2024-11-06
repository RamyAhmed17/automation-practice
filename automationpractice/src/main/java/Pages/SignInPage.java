package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.GUIActions.*;

public class SignInPage {

    private final WebDriver driver;
    private final GUIActions guiActions;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    By AlreadyregisteredElement = By.id("email");
    By PasswordElment = By.id("passwd");
    By submitElement = By.id("SubmitLogin");
    By logout =By.xpath ("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    By topMenuElement=By.xpath("//*[@id=\"header\"]/div[2]");

    public void userSignIn(String email, String Pass) {
        setText(AlreadyregisteredElement, email);
        setText(PasswordElment, Pass);
        clickButton(submitElement);

    }
    public void userCanlogout(){
        clickButton(logout);
    }
    public  String logoutText(){
        return getText(logout);
    }
    public String accountInformation(){
        return getText(topMenuElement);
    }

}
