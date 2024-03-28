package homework17;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.railway.HomePage;
import pageObjects.railway.SearchPage;

import static com.codeborne.selenide.Selenide.back;

public class StationTests extends BaseTestSelenide {

    @Test(priority = 1, dataProvider = "stations")
    public void validStationTest(String from, String dateTag) {
        get(HomePage.class)
                .clickScheduleByStation()
                .enterFromStation(from)
                .clickSearchBtnStation()
                .clickDateTag(dateTag);
        Assert.assertTrue(get(SearchPage.class).getStationTitle().contains(from));
        back();
    }

    @DataProvider(name = "stations")
    public Object[][] stationsDataProvider() {
        return new Object[][] {
                {"Минск", "сегодня"},
                {"Барановичи", "завтра"},
                {"Орша", "все дни"}
        };
    }

    @Test(priority = 2)
    public void byTrainNumberTest() {
        get(HomePage.class)
                .clickScheduleByStation()
                .clickByTrainNumberRbtn()
                .enterTrainNumber("103")
                .clickSearchByTrainNumber();
    }
}
