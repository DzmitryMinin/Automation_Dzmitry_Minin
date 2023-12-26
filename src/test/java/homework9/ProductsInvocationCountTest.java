package homework9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

import static driver.DriverCreation.createDriver;
import static driver.DriverTypes.CHROME;

public class ProductsInvocationCountTest extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Parameters({"url", "userName", "password"})
    @BeforeTest
    public void precondition(@Optional("") String url, @Optional("") String userName, @Optional("") String password) {
        loginPage = new LoginPage();
        loginPage.open(url);
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Test(priority = 1, invocationCount = 3)
    public void addAndRemoveProducts() {
        productPage = new ProductPage();
        cartPage = new CartPage();
        productPage.verifyPage();
        productPage.clickAddToCart("Sauce Labs Bike Light");
        cartPage.openCart();
        cartPage.verifyPage();
        cartPage.removeItem("Sauce Labs Bike Light");
        cartPage.ContinueShopping();
    }
}
