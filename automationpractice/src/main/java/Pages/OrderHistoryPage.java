package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.GUIActions.getText;

public class OrderHistoryPage {
    private final WebDriver driver;
    private final GUIActions guiActions;

    public OrderHistoryPage(WebDriver driver) {
        guiActions = new GUIActions(driver);
        this.driver = driver;
    }

    By orderRef =By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]");

    public String lastOrderReference(){
        return getText(orderRef);
    }


}
