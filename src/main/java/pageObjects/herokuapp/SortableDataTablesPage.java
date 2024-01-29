package pageObjects.herokuapp;

import driver.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.baseObjects.BasePage;

import java.net.Inet4Address;
import java.util.List;
import java.util.stream.Collectors;

public class SortableDataTablesPage extends BasePage implements HerokuApp{
    private final By header = By.tagName("h3");
    private final By cell = By.tagName("td");


    private WebElement getTable(Integer tableIndex) {
        return driver.findElement(By.id("table" + tableIndex));
    }

    private List<WebElement> getHeaders(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.tagName("th"));
    }

    private List<WebElement> getTableRows(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.xpath("//tbody//tr"));
    }

    private List<WebElement> getTableEmails(Integer tableIndex) {
        return getTable(tableIndex).findElements(By.xpath("//tbody//tr//td[@class='email']"));
    }
    public void clickEdit() {
        UIElement element = new UIElement(driver.findElement(By.linkText("edit")), wait);
        element.click();
    }

    @Override
    public void verifyPageLoaded() {

    }

    @Override
    public void verifyTitleText() {
        waitUntilTextToBe(header, "Data Tables");
    }

    public List<String> getTableHeaders(Integer tableIndex) {
        return getHeaders(tableIndex).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTableRowData(Integer tableIndex, Integer tableRowIndex) {
        return getTableRows(tableIndex)
                .get(tableRowIndex - 1)
                .findElements(cell).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> getTableEmailsData(Integer tableIndex) {
        return getTableEmails(tableIndex)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public List<String> convertToGmail(Integer tableIndex) {
        return getTableEmailsData(tableIndex).stream().map(element -> {
            int index = element.indexOf("@");
            return (index != -1) ? element.substring(0, index + 1)
                    .concat("gmail.com") : element;
        }).collect(Collectors.toList());
    }
}
