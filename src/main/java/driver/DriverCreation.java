package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.time.Duration;

public class DriverCreation {
    private static WebDriver webDriver;

    public static void createDriver (DriverTypes type) {
        if (webDriver == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("start-maximized");
                    webDriver = new ChromeDriver(options);
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                case IE:
                    InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                    webDriver = new InternetExplorerDriver(internetExplorerOptions);
                    break;
            }
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }
    }
}
