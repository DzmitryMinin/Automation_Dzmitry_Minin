package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public class CheckoutStepTwo extends BasePage {
    private final By header = By.className("app_logo");
    private final By title = By.xpath("//*[@id='header_container']/descendant::span[2]");
    private final By paymentInformation = By.xpath("//*[contains(text(), 'Payment')]");
    private final By shippingInformation = By.xpath("//*[text()='Shipping Information']");
    private final By priceTotalLabel = By.xpath("//*[text()='Price Total']");
    private final By total = By.cssSelector("div[class*='summary_total_label']");
    private final By cancelBtn = By.id("cancel");
    private final By finishBtn = By.id("finish");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header");
        Assert.assertEquals(getDriver().findElement(title).getText(), "Checkout: Overview", "Wrong title");
        Assert.assertEquals(getDriver().findElement(paymentInformation).getText(), "Payment Information", "Wrong label");
        Assert.assertEquals(getDriver().findElement(shippingInformation).getText(), "Shipping Information", "Wrong label");
        Assert.assertEquals(getDriver().findElement(priceTotalLabel).getText(), "Price Total", "Wrong label");
        Assert.assertEquals(getPartialTotalPriceText(), "Total: $", "Wrong label");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Wrong url");
    }

    public String getPartialTotalPriceText() {
        String totalPriceText = getDriver().findElement(total).getText();
        return totalPriceText.substring(0, Math.min(8, totalPriceText.length()));
    }

    public void finishPayment() {
        click(finishBtn);
    }
}
