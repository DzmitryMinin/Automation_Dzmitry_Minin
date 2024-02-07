package pageFactory.saucedemo;

import entities.saucedemo.Product;
import entities.saucedemo.ProductBuilder;
import entities.saucedemo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class CartPage extends BasePage implements Page<CartPage> {
    @FindBy(className = "app_logo")
    WebElement header;

    @FindBy(xpath = "//*[@id='header_container']/descendant::span[2]")
    WebElement title;

    @FindBy(css = "div[id='shopping_cart_container']")
    WebElement cartLink;

    @FindBy(css = "[class*=checkout]")
    WebElement checkoutBtn;

    private final By removeBtn = By.xpath("//button[contains(@class,'btn btn_secondary btn_small cart_button')]");

    @FindBy(css = "[class$=btn_medium]")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    List<WebElement> list;

    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public CartPage verifyPage() {
        Assert.assertEquals(header.getText(), "Swag Labs", "Wrong header");
        Assert.assertEquals(title.getText(), "Your Cart", "Wrong title");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/cart.html", "Wrong url");
        return this;
    }

    public CartPage openCart() {
        click(cartLink);
        return this;
    }

    public CartPage proceedToCheckoutStepOne() {
        click(checkoutBtn);
        return this;
    }

    public CartPage ContinueShopping() {
        click(continueShoppingBtn);
        return this;
    }

    public CartPage removeItem(Product productName) {
        List<WebElement> allProducts = list;
        for (WebElement product: allProducts) {
            if (product.getText().equals(productName.getProductName())) {
                click(product.findElement(removeBtn));
            }
        }
        return this;
    }

    public CartPage removeItem(ProductBuilder productBuilder) {
        List<WebElement> allProducts = list;
        for (WebElement product: allProducts) {
            if (product.getText().equals(productBuilder.getProduct())) {
                click(product.findElement(removeBtn));
            }
        }
        return this;
    }

    @Override
    public CartPage waitUntilPageLoaded(){
        wait.until(ExpectedConditions.visibilityOf(continueShoppingBtn));
        return this;
    }
}
