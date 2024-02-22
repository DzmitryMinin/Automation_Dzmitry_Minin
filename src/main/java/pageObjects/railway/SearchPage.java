package pageObjects.railway;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import java.util.Arrays;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchPage {
    private final ElementsCollection dates = $$x("//ul[@class='sch-links__nav list-reset']//span");

    private final SelenideElement notFoundStation = $x("*//div[@class='edit_list' and contains(text(), 'Станция')]");
    private final SelenideElement stationTitle = $x("//div[@class='sch-title__title h2']");

    public SearchPage verifyDates(String dates) {
        Arrays.asList(dates).forEach(date -> this.dates.find(matchText(date)).should(exist));
        return this;
    }

    public SearchPage clickDate(String date) {
        dates.find(matchText(date)).click();
        return this;
    }

    public String getNotFoundStation() {
        return notFoundStation.should(visible).getText();
    }

    public String getStationTitle() {
        return stationTitle.should(visible).getText();
    }
}
