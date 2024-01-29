package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;
import propertyUtils.PropertyReader;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends BasePage {
    private final HomeSteps steps;

    public HomePage() {
        steps = new HomeSteps(this);
    }

    public HomeSteps getSteps() {
        return steps;
    }
    private By getItemLocator(String item) {
        return By.linkText(item);
    }

    public void open(String url) {
        navigateTo(url);
    }

    public void open() {
        open(PropertyReader.getProperties().getProperty("url"));
    }

    public void clickOnItem(HomePageItems item) {
        wait.until(elementToBeClickable(getItemLocator(item.getItem())));
        click(getItemLocator(item.getItem()));
    }
}
