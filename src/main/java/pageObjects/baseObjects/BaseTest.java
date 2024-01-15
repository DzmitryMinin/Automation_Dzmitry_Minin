package pageObjects.baseObjects;

import driver.DriverTypes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.InvokedListener;
import testngUtils.Listener;

import static driver.DriverCreation.*;
import static driver.DriverTypes.*;
import static propertyUtils.PropertyReader.*;

@Listeners({Listener.class, InvokedListener.class})
public class BaseTest {
    @BeforeTest
    protected void setUp() {
        createDriver(System.getProperties().contains("config")
                ? valueOf(getProperties().getProperty("browser").toUpperCase())
                : CHROME
                );
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        quitDriver();
    }
}
