package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;

public class LoginPage extends BasePage {
    private final By header = By.className("login_logo");
    private final By username = By.id("user-name");
    private final By password = By.name("password");
    private final By login = By.cssSelector("input[value='Login']");
    private By loginCredentials = By.id("login_credentials");
    private By passwordCredentials = By.className("login_password");
    private final By errorTextLockedUser = By.xpath("//*[contains(text(),'locked out')]");
    private final By errorTextIncorrectPassword = By.xpath("//*[contains(text(),'password do not match')]");

    public void open(String url) {
        getDriver().get(url);
    }

    public void verifyPage() {
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs");
        Arrays.asList(username, password, login).forEach(el -> Assert.assertTrue(getDriver().findElement(el).isDisplayed(), "Element is not displayed: " + el));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/", "Wrong header url");
    }

    public void verifyErrorForLockedUser() {
        Assert.assertEquals(getDriver().findElement(errorTextLockedUser).getText(), "Epic sadface: Sorry, this user has been locked out.", "Wrong error message");
    }

    public void verifyErrorForIncorrectPassword() {
        Assert.assertEquals(getDriver().findElement(errorTextIncorrectPassword).getText(), "Epic sadface: Username and password do not match any user in this service", "Wrong error message");
    }


    public void enterUsername(String username) {
        sendKeys(this.username, username);
    }

    public void enterPassword(String password) {
        sendKeys(this.password, password);
    }

    public void clickLogin() {
        click(login);
    }

    public List<String> getUsernames() {
        return Arrays.stream(getDriver().findElement(loginCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Accepted usernames are"))
                .collect(Collectors.toList());
    }

    public String getPassword() {
        return Arrays.stream(getDriver().findElement(passwordCredentials).getText().split("\n"))
                .filter(value -> !value.contains("Password for all users"))
                .findFirst().orElse("");
    }
}
