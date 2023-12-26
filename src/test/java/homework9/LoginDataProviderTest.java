package homework9;

import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;

import static driver.DriverCreation.quitDriver;

public class LoginDataProviderTest extends BaseTest {
    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @Parameters({"url"})
    @BeforeTest
    public void precondition(@Optional("") String url) {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        loginPage.open(url);
    }

    @Test(priority = 1, dataProvider = "user name data")
    public void loginTest(String userName, String password, Boolean loginStatus) {
        loginPage.verifyPage();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (loginStatus) {
            navigationPage.openMenu();
            navigationPage.clickMenuItem("Logout");
        }
    }

    @DataProvider(name = "user name data")
    public Object[][] getUserData() {
        return new Object[][] {
                {"standard_user", "secret_sauce", true},
                {"wrong_user", "secret_sauce", false},
                {"standard_user", "wrong_password", false},
                {"wrong_user", "wrong_password", false}
        };
    }

    @AfterTest
    public void quit() {
        quitDriver();
    }
}
