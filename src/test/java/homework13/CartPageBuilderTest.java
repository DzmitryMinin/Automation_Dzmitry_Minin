package homework13;

import entities.saucedemo.ProductBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.CartPage;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class CartPageBuilderTest extends BaseTest {
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

    @Test(dataProvider = "get product builder", priority = 1)
    public void addProductsToCartList(ProductBuilder product) {
        ProductPage productPage = new ProductPage();
        productPage
                .waitUntilPageLoaded()
                .clickAddToCart(product);
    }

    @Test(dataProvider = "get product builder", priority = 2)
    public void openCartAndRemoveOneItem(ProductBuilder product) {
        CartPage cartPage = new CartPage();
        cartPage
                .openCart()
                .waitUntilPageLoaded()
                .removeItem(product);
    }

    @DataProvider(name = "get product builder")
    public Object[][] getProductDataBuilder() {
        return new Object[][]{
                {ProductBuilder.builder()
                        .withProduct("Sauce Labs Bolt T-Shirt")
                        .build()},
                {ProductBuilder.builder()
                        .withProduct("Sauce Labs Bike Light")
                        .build()},
                {ProductBuilder.builder()
                        .withProduct("Sauce Labs Bolt T-Shirt")
                        .build()},
                {ProductBuilder.builder()
                        .withProduct("Sauce Labs Fleece Jacket")
                        .build()},
        };
    }
}
