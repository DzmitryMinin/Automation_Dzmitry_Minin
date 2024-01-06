package homework10;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class SuccessLoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @Test
    public void successLoginWithProperties() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
}