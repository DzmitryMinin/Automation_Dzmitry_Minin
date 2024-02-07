package homework13;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageFactory.saucedemo.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void setUpTest() {
        loginPage.open();
    }

    @Test(priority = 1, dataProvider = "user name data")
    public void loginTest(String userName) {
        loginPage
                .waitUntilPageLoaded()
                .verifyPage()
                .enterUsername(userName)
                .enterPassword(loginPage.getPassword())
                .clickLogin();
    }

    @DataProvider(name = "user name data")
    public Object[][] getUserData() {
        return new Object[][] {
                {"standard_user"},
                {"wrong_user"},
                {"standard_user"},
                {"wrong_user"}
        };
    }
}
