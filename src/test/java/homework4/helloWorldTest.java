package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class helloWorldTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }

    @Test
    public void SearchHelloWorld() {
        driver.get("https://www.google.by/");
        WebElement searchBar = driver.findElement(By.cssSelector("[class='gLFyf']"));
        searchBar.sendKeys("Hello world");
        searchBar.sendKeys(Keys.ENTER);
        WebElement allTab = driver.findElement(By.cssSelector("[class='hdtb-mitem hdtb-msel']"));
        Boolean result = allTab.isDisplayed();
        Assert.assertTrue(result);
    }
}
