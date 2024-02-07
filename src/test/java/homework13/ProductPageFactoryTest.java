package homework13;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageFactory.saucedemo.ProductPage;
import pageObjects.baseObjects.BaseTest;

public class ProductPageFactoryTest extends BaseTest {

    private ProductPage productPage;

    @BeforeTest
    public void precondition() {
        LoginPage loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage
                .open()
                .enterUsername()
                .enterPassword()
                .clickLogin();
    }

    @Test(dataProvider = "index", priority = 1)
    public void addProductsToCartList(Integer index) {
        productPage
                .waitUntilPageLoaded()
                .clickAddToCart(index);
    }

    @DataProvider(name = "index")
    public Object[][] getData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4}
        };
    }
}
