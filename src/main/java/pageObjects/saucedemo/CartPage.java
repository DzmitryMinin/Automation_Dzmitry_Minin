package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By title = By.xpath("//*[@id='header_container']/descendant::span[2]");
    private final By cartLink = By.cssSelector("div[id='shopping_cart_container']");
    private final By checkoutBtn = By.cssSelector("[class*=checkout]");
    private final By removeBtn = By.cssSelector(".btn.btn_secondary.btn_small.cart_button");
    private final By continueShoppingBtn = By.cssSelector("[class$=btn_medium]");

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header");
        Assert.assertEquals(getDriver().findElement(title).getText(), "Your Cart", "Wrong title");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong url");
    }

    public void openCart() {
        click(cartLink);
    }

    public void proceedToCheckoutStepOne() {
        click(checkoutBtn);
    }

    public void removeItem(Integer index) {
        click(getDriver().findElements(removeBtn).get(index));
    }

    public void ContinueShopping() {
        click(continueShoppingBtn);
    }
}
