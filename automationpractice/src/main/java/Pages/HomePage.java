package Pages;

import helper.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static helper.GUIActions.clickButton;

public class HomePage {
    private final WebDriver driver;
    private final Actions actions;
    private final GUIActions guiActions;



    By signIN = By.cssSelector("a.login");
    private final By women = By.cssSelector("a[title=\"Women\"]");
    private final By blouse = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[2]/a");
    private final By account = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
        actions = new Actions(driver);

    }

    public void clickSignIn() {
        clickButton(signIN);
    }

    public void clickMyAccount() {
        clickButton(account);
    }

    public ProductPage selectBlousesByHoverWomenMenu() {
        WebElement action= driver.findElement(women);
        actions.moveToElement(action).perform();
        clickButton(blouse);
        return new ProductPage(driver);
    }


}
