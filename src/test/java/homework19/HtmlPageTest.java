package homework19;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.htmlPage.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class HtmlPageTest extends BaseTestSelenide {
    @BeforeTest
    public void openHtmlPage() {
        open("file://" + System.getProperty("user.dir") + "/src/test/java/homework19/html/table.html");
    }

    @Test(priority = 1)
    public void getTableData() {
        get(HomePage.class).getTableFirstRow();
    }

    @Test(priority = 2)
    public void enterValue() {
        get(HomePage.class).enterTextValue("test text");
    }

    @Test(priority = 3)
    public void clickCheckbox() {
        get(HomePage.class).clickCheckbox();
    }

    @Test(priority = 4)
    public void selectElement() {
        get(HomePage.class).selectElement("Saab");
    }

    @Test(priority = 5)
    public void clickBtn() {
        get(HomePage.class).clickBtn();
    }

    @Test(priority = 6)
    public void verifyImg() {
        get(HomePage.class).verifyImg();
    }

    @Test(priority = 7)
    public void verifyText() {
        get(HomePage.class).verifyTagText("the image is located below this text");
    }

    @Test(priority = 8)
    public void verifyLink() {
        get(HomePage.class).checkExternalPage("https://www.google.com/");
    }
}
