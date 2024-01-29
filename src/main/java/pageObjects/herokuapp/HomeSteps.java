package pageObjects.herokuapp;

public class HomeSteps {
    private final HomePage homePage;

    public HomeSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    public void navigateTo(HomePageItems item) {
        homePage.open();
        homePage.clickOnItem(item);
    }
}
