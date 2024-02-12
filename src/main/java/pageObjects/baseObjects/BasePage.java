package pageObjects.baseObjects;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

@Log4j
public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    {
        driver = getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    protected void navigateTo(String url) {
        log.info("Navigate to :: " + url);
        driver.get(url);
    }

    protected void click(By by) {
        click(driver.findElement(by));
    }

    protected void click(WebElement element) {
        log.info("Click on element: " + element);
        wainUntilElementToBeClickable(element);
        element.click();
    }

    protected void sendKeys(By by, CharSequence... charSequences) {
        sendKeys(getDriver().findElement(by), charSequences);
    }

    protected void sendKeys(WebElement element, CharSequence... charSequences) {
        log.info("Enter in: " + element + ", next values: " + Arrays.toString(charSequences));
        element.clear();
        element.sendKeys(charSequences);
    }

    protected void waitUntilTextToBe(By by, String expectedText) {
        log.info("Wait until text to be: " + expectedText);
        wait.until(ExpectedConditions.textToBe(by, expectedText));
    }

    protected void wainUntilElementToBeClickable(By by) {
        wainUntilElementToBeClickable(driver.findElement(by));
    }

    protected void wainUntilElementToBeClickable(WebElement element) {
        log.info("Wait until element to be clickable: " + element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected String getElementText(By by) {
        return getElementText(driver.findElement(by));
    }

    protected String getElementText(WebElement webElement) {
        return webElement.getText();
    }

    protected List<String> getElementTexts(By by) {
        return getElementTexts(driver.findElements(by));
    }

    protected List<String> getElementTexts(List<WebElement> webElement) {
        return webElement.stream().map(data -> data.getText()).collect(Collectors.toList());
    }
}
