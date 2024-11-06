package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helper.GUIActions.clickButton;

public class MyAccountPage {
    private final WebDriver driver;
    private final GUIActions guiActions;

    public MyAccountPage(WebDriver driver) {
        this.driver=driver;
        guiActions = new GUIActions(driver);
    }
    By orderHistoryElement  = By.xpath( "//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a");

    public OrderHistoryPage openOrderPage(){
        clickButton(orderHistoryElement);
        return new OrderHistoryPage(driver);
    }
}