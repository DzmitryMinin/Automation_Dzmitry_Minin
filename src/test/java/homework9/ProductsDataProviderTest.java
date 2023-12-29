package homework9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.CartPage;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.ProductPage;

public class ProductsDataProviderTest extends BaseTest {
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

    @Test(priority = 1, dataProvider = "product names")
    public void addProductsToCart(String productName) {
        productPage = new ProductPage();
        productPage.verifyPage();
        productPage.clickAddToCart(productName);
    }

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
