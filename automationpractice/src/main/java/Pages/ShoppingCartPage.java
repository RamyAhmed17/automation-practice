package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.GUIActions.clickButton;
import static helper.GUIActions.getText;

public class ShoppingCartPage {
    private final WebDriver driver;
    private final GUIActions guiActions;


    public ShoppingCartPage(WebDriver driver) {
        guiActions = new GUIActions(driver);
        this.driver = driver;
    }

    private final By checkoutBttn = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
    private final By adressCheckout = By.xpath("//*[@id=\"center_column\"]/form/p/button");
    private final By agreecheckbox = By.xpath("//*[@id=\"cgv\"]");
    private final By shippingCheckoutBttn = By.xpath("  //*[@id=\"form\"]/p/button");
    private final By bankWireElement = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private final By confirmationBttn = By.xpath("//*[@id=\"cart_navigation\"]/button");
    private final By checkCart = By.xpath("//*[@id=\"cart_summary\"]/tbody");
    private final By detailsBox = By.xpath("//*[@id=\"center_column\"]/div\n");
    private final By typeOfPaymentElement = By.xpath("//*[@id=\"center_column\"]/form/div");
    public String typeOfPayment;


    public String checkBlouseIsAddedToCart() {
        return getText(checkCart);
    }

    public void userFinalCheckout() {
        clickButton(checkoutBttn);
        clickButton(adressCheckout);
        clickButton(agreecheckbox);
        clickButton(shippingCheckoutBttn);
        clickButton(bankWireElement);
        typeOfPayment=getText(typeOfPaymentElement);
    }
    public void userFinalConfirmation() {
        clickButton(confirmationBttn);
    }
    public String detailsOfMyOrder(){
        return getText(detailsBox);
    }

}