package pageFactory.saucedemo;

import entities.saucedemo.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class LoginPage extends BasePage implements Page<LoginPage> {

    @FindBy(how = How.CLASS_NAME, using = "login_logo")
    WebElement header;

    @FindBy(how = How.ID, using = "user-name")
    WebElement username;

    @FindBy(how = How.NAME, using = "password")
    WebElement password;

    @FindBy(how = How.CSS, using = "input[value='Login']")
    WebElement login;

    @FindBy(how = How.ID, using = "login_credentials")
    WebElement loginCredentials;

    @FindBy(how = How.CLASS_NAME, using = "login_password")
    WebElement passwordCredentials;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'locked out')]")
    WebElement errorTextLockedUser;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'password do not match')]")
    WebElement errorTextIncorrectPassword;


    public LoginPage open(String url) {
        getDriver().get(url);
        return this;
    }

    public LoginPage open() {
        getDriver().get(getProperties().getProperty("url"));
        return this;
    }

    public LoginPage verifyPage() {
        Assert.assertEquals(header.getText(), "Swag Labs");
        Arrays.asList(username, password, login).forEach(el -> Assert.assertTrue(el.isDisplayed(), "Element is not displayed: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong header url");
        return this;
    }

    public LoginPage verifyErrorForLockedUser() {
        Assert.assertEquals(errorTextLockedUser.getText(), "Epic sadface: Sorry, this user has been locked out.", "Wrong error message");
        return this;
    }

    public LoginPage verifyErrorForIncorrectPassword() {
        Assert.assertEquals(errorTextIncorrectPassword.getText(), "Epic sadface: Username and password do not match any user in this service", "Wrong error message");
        return this;
    }


    public LoginPage enterUsername(String username) {
        sendKeys(this.username, username);
        return this;
    }

    public LoginPage enterUsername() {
        sendKeys(this.username, getProperties().getProperty("username"));
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(this.password, password);
        return this;
    }

    public LoginPage enterPassword() {
        sendKeys(this.password, getProperties().getProperty("password"));
        return this;
    }

    public LoginPage login(String username, String password) {
        return enterUsername(username).enterPassword(password);
    }

    public LoginPage login(User user) {
        return enterUsername(user.getUsername()).enterPassword(user.getPassword());
    }

    public LoginPage clickLogin() {
        click(login);
        return this;
    }

    public List<String> getUsernames() {
        return Arrays.stream(loginCredentials.getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return Arrays.stream(passwordCredentials.getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }
    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Override
    public LoginPage waitUntilPageLoaded() {
        Arrays.asList(username, password, login).forEach(el -> wait.until(ExpectedConditions.visibilityOf(el)));
        return this;
    }
}
