package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.GUIActions.clickButton;
import static helper.GUIActions.getText;

public class ProductPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    public ProductPage(WebDriver driver) {
        guiActions = new GUIActions(driver);
        this.driver = driver;
    }
    private final By itemHeader = By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span");
    private final By addtocart = By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[2]/div[2]/a[1]");
    private final By pCheckout = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");


    public String checkYouInBlousesPage() {
        return getText(itemHeader);
    }

    public void addToCart() {
        clickButton(addtocart);
    }

    public void proceedToCheckOut() {
        clickButton(pCheckout);
    }}
