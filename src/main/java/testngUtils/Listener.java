package testngUtils;

import org.testng.ITestListener;
import org.testng.ITestContext;

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
