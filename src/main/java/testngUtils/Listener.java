package testngUtils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.setUpProperty;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        if (System.getProperties().containsKey("config")) {
            setUpProperty(System.getProperty("config"));
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("test: " + context.getSuite().getName());
    }
}
