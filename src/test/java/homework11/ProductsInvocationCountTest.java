package homework11;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class ProductsInvocationCountTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.open();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }

    @Description("Add and remove products from cart")
    @Step("Add/Remove products")
    @Test(priority = 1, invocationCount = 3)
    public void addAndRemoveProducts() {
        productPage = new ProductPage();
        cartPage = new CartPage();
        productPage.clickAddToCart("Sauce Labs Bike Light");
        cartPage.openCart();
        cartPage.verifyPage();
        cartPage.removeItem("Sauce Labs Bike Light");
        cartPage.ContinueShopping();
    }
}
