package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.String;
import java.time.Duration;

public class GUIActions {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public GUIActions(WebDriver driver) {
        GUIActions.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void clickButton(By button) {
        wait.until(ExpectedConditions.presenceOfElementLocated(button));
        WebElement element = driver.findElement(button);
        element.click();
    }

    public static void setText(By textElement, String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(textElement));
        WebElement element = driver.findElement(textElement);
        element.clear();
        element.sendKeys(value);
    }

    public static String  getText(By textElement) {
        wait.until(ExpectedConditions.presenceOfElementLocated(textElement));
        WebElement element = driver.findElement(textElement);
        return element.getText();
    }


}





