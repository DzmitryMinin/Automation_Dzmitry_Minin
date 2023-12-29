package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Frames extends BasePage {
    private final By header = By.tagName("h3");
    private final By frame = By.id("mce_0_ifr");
    private final By textField = By.tagName("p");

    private By getItem(String name) {
        return By.linkText(name);
    }

    public void verifyTitleText() {
        wait.until(textToBe(header,"Frames"));
    }

    public void clickOnItem(String itemName) {
        click(getItem(itemName));
    }

    public void switchToFrame() {
        wait.until(visibilityOf(driver.findElement(frame)));
        driver.switchTo().frame(driver.findElement(frame));
    }

    public void enterText(String text) {
        System.out.println(driver.findElement(textField).getText());
        sendKeys(textField, text);
    }

    public void unSwitchToFrame() {
        driver.switchTo().defaultContent();
    }

    public void verifyText() {
        Assert.assertEquals(driver.findElement(textField).getText(), "Your content goes here.", "Wrong text");
    }
}
