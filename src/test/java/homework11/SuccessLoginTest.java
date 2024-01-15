package homework11;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;

public class SuccessLoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        loginPage.open();
    }

    @Description("Successful login test")
    @Step("Log in to the system")
    @Test(priority = 1)
    public void loginTest() {
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
    }
}
