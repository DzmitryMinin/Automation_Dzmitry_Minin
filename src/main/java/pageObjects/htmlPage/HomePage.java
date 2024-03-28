package pageObjects.htmlPage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

@Log4j
public class HomePage {
    private final ElementsCollection tableFirstRow = $$x("//tbody//tr//td[1]");
    private final SelenideElement input = $("input[id='comp_id']");
    private final SelenideElement checkbox = $("input[id='checkboxes']");
    private final SelenideElement select = $("select[id='cars']");
    private final SelenideElement button = $("button[type='button']");
    private final SelenideElement image = $("img[src='volvo.jpg']");
    private final SelenideElement tagP = $("p[id='tagP']");
    private final SelenideElement link = $("a[href='https://www.google.com/']");

    public HomePage getTableFirstRow() {
        log.info(tableFirstRow.texts());
        return this;
    }

    public HomePage enterTextValue(String text) {
        this.input.should(enabled).setValue(text);
        return this;
    }

    public HomePage clickCheckbox() {
        checkbox.click();
        return this;
    }

    public HomePage selectElement(String model) {
        select.shouldBe(enabled).selectOption(model);
        return this;
    }

    public HomePage clickBtn() {
        button.shouldBe(enabled).click();
        return this;
    }

    public HomePage verifyImg() {
        image.should(exist).isDisplayed();
        return this;
    }

    public HomePage verifyTagText(String expectedText) {
        Assert.assertTrue(tagP.getText().equals(expectedText));
        return this;
    }

    public HomePage checkExternalPage(String url) {
        link.shouldBe(visible).click();
        Assert.assertTrue(WebDriverRunner.getWebDriver().getCurrentUrl().equals(url));
        return this;
    }
}
