package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBeNotEmpty;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class DynamicControls extends BasePage {
    private final By header = By.xpath("//*[text()='Dynamic Controls']");
    private final By checkbox = By.id("checkbox");
    private final By removeBtn = By.xpath("//*[text()='Remove']");
    private final By itsGoneText = By.id("message");
    private final By input = By.xpath("//*[@id='input-example']/descendant::input");
    private final By btn = By.xpath("//*[@id='input-example']/descendant::button");
    private final By itsEnabledText = By.xpath("//*[@id='input-example']/descendant::p");

    public void verifyHeaderText() {
        Assert.assertEquals(driver.findElement(header).getText(), "Dynamic Controls", "Wrong title");
    }

    public void clickOnRemoveBtn() {
        click(removeBtn);
    }

    public void verifyAppearedText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itsGoneText));
        Assert.assertEquals(driver.findElement(itsGoneText).getText(), "It's gone!", "Wrong text");
    }

    public void verifyThatCheckboxDisappears() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
    }

    public void verifyIfDisabled() {
        wait.until(attributeToBeNotEmpty(driver.findElement(input), "disabled"));
    }

    public void clickOnDisabledBtn() {
        click(btn);
    }

    public void verifyIfEnabledTextAppears() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(itsEnabledText));
        Assert.assertEquals(driver.findElement(itsEnabledText).getText(), "It's enabled!", "Wrong text");
    }

    public void verifyIfEnabled() {
        wait.until(not(attributeToBeNotEmpty(driver.findElement(input), "disabled")));
    }
}
