package pageObjects.railway;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.SelectRadio;
import org.openqa.selenium.By;
import org.w3c.dom.html.HTMLObjectElement;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement from = $("[name='from']");
    private final SelenideElement to = $("[name='to']");
    private final SelenideElement searchBtn = $x("(//button[@type='submit'])[1]");
    private final ElementsCollection dateTags = $$x("(//div[@class='rasp-form__tags'])[3]//a");
    private final SelenideElement byStationTab = $x("(//span[text() = 'Расписание по станции и номеру поезда'])[1]");
    private final SelenideElement fromStation = $(By.id("by-station-raspFormFromTitle"));
    private final SelenideElement searchBtnStation = $x("(//button[text() = 'Найти'])[7]");
    private final SelenideElement trainNumberRbtn = $x("(//div[@class='jq-radio__div'])[5]");
    private final SelenideElement trainNumber = $x("//input[@placeholder='Номер поезда']");
    private final SelenideElement searchBtnTrain = $x("(//button[text() = 'Найти'])[8]");


    public HomePage enterFrom(String from) {
        this.from.should(visible).clear();
        this.from.sendKeys(from);
        return this;
    }

    public HomePage enterFromStation(String fromStation) {
        this.fromStation.should(visible).clear();
        this.fromStation.setValue(fromStation);
        return this;
    }

    public HomePage enterTo(String to) {
        this.to.should(visible).clear();
        this.to.sendKeys(to);
        return this;
    }

    public HomePage clickSearch() {
        searchBtn.should(enabled).click();
        return this;
    }

    public HomePage clickDateTag(String dateTag) {
        dateTags.find(matchText(dateTag)).click();
        return this;
    }

    public HomePage clickScheduleByStation() {
        byStationTab.should(visible).click();
        return this;
    }

    public HomePage clickSearchBtnStation() {
        searchBtnStation.should(enabled, visible).click();
        return this;
    }

    public HomePage clickByTrainNumberRbtn() {
        trainNumberRbtn.should(visible).click();
        return this;
    }

    public HomePage enterTrainNumber(String trainNumber) {
        this.trainNumber.should(visible).clear();
        this.trainNumber.setValue(trainNumber);
        return this;
    }

    public HomePage clickSearchByTrainNumber() {
        searchBtnTrain.should(enabled, visible).click();
        return this;
    }
}
