package homework6_7;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.*;

public class SauceDemoTests extends BaseTest {
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutStepOne checkoutStepOne;
    private CheckoutStepTwo checkoutStepTwo;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutStepOne = new CheckoutStepOne();
        checkoutStepTwo = new CheckoutStepTwo();
        loginPage.open("https://www.saucedemo.com");
    }

    @Test(priority = 1)
    public void unsuccessfulLoginWithLockedUser() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(1));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
        loginPage.verifyErrorForLockedUser();
    }

    @Test(priority = 2)
    public void unsuccessfulLoginWithProblemUser() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(2));
        loginPage.enterPassword("123");
        loginPage.clickLogin();
        loginPage.verifyErrorForIncorrectPassword();
    }

    @Test(priority = 3)
    public void successfulLogin() {
        loginPage.verifyPage();
        loginPage.enterUsername(loginPage.getUsernames().get(0));
        loginPage.enterPassword(loginPage.getPassword());
        loginPage.clickLogin();
    }


    @Test(priority = 4)
    public void addSeveralProductsToCart() {
        productPage.verifyPage();
        //productPage.clickAddToCart(1);
        //productPage.clickAddToCart(2);
    }

    @Test(priority = 5)
    public void openCartAndRemoveOneItem() {
        cartPage.openCart();
        cartPage.verifyPage();
        //cartPage.removeItem(1);
    }

    @Test(priority = 6)
    public void submitCommonInfo() {
        cartPage.proceedToCheckoutStepOne();
        checkoutStepOne.verifyPage();
        checkoutStepOne.fillInInformation("Dzmitry", "Test", "220019");
        checkoutStepOne.proceedToCheckoutStepTwo();
    }

    @Test(priority = 7)
    public void finishPayment() {
        checkoutStepTwo.verifyPage();
        checkoutStepTwo.finishPayment();
    }
}
