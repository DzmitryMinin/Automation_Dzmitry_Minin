package pageObjects.rabotaby;

import com.codeborne.selenide.SelenideElement;
import pageObjects.baseObjects.BaseTestSelenide;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage extends BaseTestSelenide {
    private final SelenideElement searchField = $("[id='a11y-search-input']");
    private final SelenideElement searchBtn = $("button[data-qa='search-button']");

    public HomePage enterVacancy(String vacancy) {
        this.searchField.should(visible).clear();
        this.searchField.setValue(vacancy);
        return this;
    }

    public HomePage searchVacancy() {
        this.searchBtn.should(enabled).click();
        return this;
    }
}
