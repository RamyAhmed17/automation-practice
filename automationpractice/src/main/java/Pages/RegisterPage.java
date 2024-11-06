package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static helper.GUIActions.clickButton;
import static helper.GUIActions.setText;

public class RegisterPage {
    private final WebDriver driver;
    private final GUIActions guiActions;

    By titlElement = By.id("uniform-id_gender1");
    By firstnameElement = By.id("customer_firstname");
    By lastnamElement = By.id("customer_lastname");
    By emailelElement = By.id("email");
    By passElement = By.id("passwd");
    By addressElement = By.id("address1");
    By cityElement = By.id("city");
    By selectstatElement = By.id("id_state");
    By postElement = By.id("postcode");
    By countryElement = By.id("id_country");
    By noElement=By.id("phone_mobile");
    By submitElement =By.xpath( "//*[@id=\"submitAccount\"]" );

    public RegisterPage(WebDriver driver) {
        guiActions = new GUIActions(driver);
        this.driver = driver;
    }

    public void userregister(String fname, String lname, String passwd, String addres, String city, String state, String zip, String mobile) {
        clickButton(titlElement);
        setText(firstnameElement,fname);
        setText( lastnamElement,lname);
        setText( passElement,passwd);
        setText( addressElement,addres);
        setText( cityElement,city);
        WebElement action = driver.findElement(selectstatElement) ;
        Select actionSelect = new Select(action);
        actionSelect.selectByVisibleText(state);
        setText( postElement,zip);
        setText(noElement,mobile);
        clickButton(noElement);
        clickButton( submitElement);
    }
}
