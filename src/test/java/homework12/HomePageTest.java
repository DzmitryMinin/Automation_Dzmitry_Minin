package homework12;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.HomePageItems;

public class HomePageTest extends BaseTest {

    @Parameters("item")
    @Test
    public void passedItemNavigationTest(String item) {
        HomePage homePage = new HomePage();
        homePage.getSteps().navigateTo(HomePageItems.valueOf(item.toUpperCase()));
    }

}
