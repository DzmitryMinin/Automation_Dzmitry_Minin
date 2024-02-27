package homework17;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.railway.HomePage;
import pageObjects.railway.SearchPage;
import static com.codeborne.selenide.Selenide.page;

public class RouteTests extends BaseTestSelenide {

    @Test(priority = 1)
    public void validRouteTest() {
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .clickSearch();

        page(SearchPage.class)
                .verifyDates("все дни")
                .clickDate("все дни");
    }

    @Test(priority = 2)
    public void invalidRouteTest() {
        get(HomePage.class)
                .enterFrom("123")
                .enterTo("123")
                .clickSearch();

        Assert.assertEquals(get(SearchPage.class).getNotFoundStation(), "Станция не найдена", "Станция найдена");
    }

    @Test(priority = 3, dataProvider = "routes")
    public void routeDataProviderTest(String from, String to, String dateTag) {
        get(HomePage.class)
                .enterFrom(from)
                .enterTo(to)
                .clickDateTag(dateTag)
                .clickSearch();
    }

    @DataProvider(name = "routes")
    public Object[][] routesDataProvider() {
        return new Object[][] {
                {"Барановичи", "Витебск", "сегодня"},
                {"Test test", "test test", "завтра"},
                {"Молодечно", " ", "все дни"}
        };
    }
}

