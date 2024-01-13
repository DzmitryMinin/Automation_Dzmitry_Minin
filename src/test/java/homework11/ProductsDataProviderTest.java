package homework11;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class ProductsDataProviderTest extends BaseTest {
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

    @Description("Add products to cart")
    @Step("Add products")
    @Test(priority = 1, dataProvider = "product names")
    public void addProductsToCart(String productName) {
        productPage = new ProductPage();
        productPage.verifyPage();
        productPage.clickAddToCart(productName);
    }

    @Description("Remove products from cart")
    @Step("Remove products")
    @Test(priority = 2, dataProvider = "product names")
    public void removeProductsFromCart(String productName) {
        cartPage = new CartPage();
        cartPage.openCart();
        cartPage.verifyPage();
        cartPage.removeItem(productName);
    }

    @DataProvider(name = "product names")
    public Object[][] getProductsData() {
        return new Object[][] {
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"}
        };
    }
}
