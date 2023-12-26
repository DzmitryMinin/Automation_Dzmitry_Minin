package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.List;

import static driver.DriverCreation.getDriver;

public class ProductPage extends BasePage {
    private final By header = By.className("app_logo");
    private final By addToCard = By.xpath("//button[contains(@class,'btn btn_primary btn_small btn_inventory')]");
    private final By list = By.className("inventory_item_name");


    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name");
        Assert.assertFalse(getDriver().findElements(list).isEmpty(), "Product list is empty");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Wrong url");
    }

    public void clickAddToCart(String productName) {
        List<WebElement> allProducts = getDriver().findElements(list);
        for (WebElement product: allProducts) {
            if (product.getText().equals(productName)) {
                click(product.findElement(addToCard));
            }
        }
    }
}
