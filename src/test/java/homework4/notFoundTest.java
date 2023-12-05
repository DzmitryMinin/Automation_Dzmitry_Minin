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

public class notFoundTest {
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
    public void notFound() {
        driver.get("https://www.google.by/");
        WebElement searchBar = driver.findElement(By.cssSelector("[class='gLFyf']"));
        searchBar.sendKeys("-DskipTests=true");
        searchBar.sendKeys(Keys.ENTER);
        WebElement nothingFound = driver.findElement(By.cssSelector("[aria-level='3']"));
        Boolean result = nothingFound.getText().equals("Па запыце -DskipTests=true нічога не знойдзена");
        Assert.assertTrue(result, "Results are shown");
    }
}
