package pageObjects.rabotaby;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import pageObjects.baseObjects.BaseTestSelenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ResultPage extends BaseTestSelenide {
    private final SelenideElement resultHeader = $x("//h1[@class='search-catalog-header']");
    private final SelenideElement resultQty = $x("//span[@class='bloko-header-section-3']");
    private final ElementsCollection results = $$x("//div[@class='serp-item serp-item_link']");
    private final SelenideElement searchFieldValue = $("input[id='a11y-search-input']");

    public ResultPage checkResultQty(Integer qty) {
        Assert.assertTrue(results.size() >= qty);
        return this;
    }

    public ResultPage verifyResultHeader() {
        Assert.assertTrue(resultHeader.should(visible).getText().contains(searchFieldValue.should(visible).getText()));
        return this;
    }

    public ResultPage verifyResultQty() {
        Assert.assertTrue(resultQty.shouldBe(visible).getText().contains(String.valueOf(results.size())));
        return this;
    }
}
