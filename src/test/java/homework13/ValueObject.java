package homework13;

import entities.saucedemo.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class ValueObject extends BaseTest {
    private LoginPage loginPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
    }

    @BeforeMethod
    public void setUpTest() {
        loginPage.open();
    }

    @Test(priority = 1)
    public void loginTest() {
        loginPage
                .waitUntilPageLoaded()
                .login(new User() {{
                    setUsername("standard_user");
                    setPassword("secret_sauce");
                }})
                .clickLogin();
    }

    @Test(priority = 2, dataProvider = "get user")
    public void loginTest(User user) {
        loginPage
                .waitUntilPageLoaded()
                .login(user)
                .clickLogin();
    }

    @DataProvider(name = "get user")
    public Object[][] getUserData() {
        return new Object[][] {
                {new User() {{
                    setUsername("standard_user");
                }}},
                {new User() {{
                    setUsername("wrong_user");
                }}},
                {new User() {{
                    setUsername("standard_user");
                }}},
                {new User() {{
                    setUsername("wrong_user");
                }}}
        };
    }

}
