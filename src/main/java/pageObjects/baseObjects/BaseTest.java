package pageObjects.baseObjects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static driver.DriverCreation.*;
import static driver.DriverTypes.*;

public class BaseTest {
    @BeforeTest
    protected void setUp() {
        createDriver(CHROME);
    }

    @AfterTest
    protected void tearDown() {
        quitDriver();
    }
}
