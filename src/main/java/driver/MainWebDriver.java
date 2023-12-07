package driver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class MainWebDriver {
    private static WebDriver webDriver;

    public static void setUpWebDriver (String url) {
        if (webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            webDriver.get(url);
        }
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
    }

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

    public static void clickBtnWhenItsVisible() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement calcButton = getWebDriver().findElement(By.cssSelector("[value='Рассчитать']"));
        js.executeScript("arguments[0].scrollIntoView();", calcButton);
        calcButton.click();
    }
}
