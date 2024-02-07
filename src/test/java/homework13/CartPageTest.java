package homework13;

import entities.saucedemo.Product;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.CartPage;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class CartPageTest extends BaseTest{
    private CartPage cartPage;

    @BeforeTest
    public void precondition() {
        LoginPage loginPage = new LoginPage();
        loginPage
                .open()
                .enterUsername()
                .enterPassword()
                .clickLogin();
    }

    @Test(dataProvider = "get product", priority = 1)
    public void addProductsToCartList(Product product) {
        ProductPage productPage = new ProductPage();
        productPage
                .waitUntilPageLoaded()
                .clickAddToCart(product);
    }

    @Test(dataProvider = "get product", priority = 2)
    public void openCartAndRemoveOneItem(Product product) {
        CartPage cartPage = new CartPage();
        cartPage
                .openCart()
                .waitUntilPageLoaded()
                .removeItem(product);
    }

    @DataProvider(name = "get product")
    public Object[][] getProductData() {
        return new Object[][]{
                {new Product() {{
                    setProductName("Sauce Labs Bolt T-Shirt");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bike Light");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Bolt T-Shirt");
                }}},
                {new Product() {{
                    setProductName("Sauce Labs Fleece Jacket");
                }}}
        };
    }
}
