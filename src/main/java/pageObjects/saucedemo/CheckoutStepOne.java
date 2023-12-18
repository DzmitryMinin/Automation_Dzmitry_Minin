package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class CheckoutStepOne extends BasePage {

    private final By header = By.className("app_logo");
    private final By title = By.xpath("//*[@id='header_container']/descendant::span[2]");
    private final By firstName = By.xpath("//input[@id='last-name']/preceding::input");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.xpath("//input[@id='last-name']/following::input");
    private final By cancelBtn = By.xpath("//button[@class='btn btn_secondary back btn_medium cart_cancel_link' and @name='cancel']");
    private final By continueBtn = By.id("continue");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header");
        Assert.assertEquals(getDriver().findElement(title).getText(), "Checkout: Your Information", "Wrong title");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html", "Wrong url");
    }

    public void fillInInformation(String firstname, String lastname, String postalcode) {
        sendKeys(this.firstName, firstname);
        sendKeys(this.lastName, lastname);
        sendKeys(this.postalCode, postalcode);
    }

    public void proceedToCheckoutStepTwo() {
        click(continueBtn);
    }

    public void cancelCheckout() {
        click(cancelBtn);
    }
}
