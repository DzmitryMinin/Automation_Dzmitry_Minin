package homework8;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.DynamicControls;
import pageObjects.herokuapp.Frames;
import pageObjects.herokuapp.HomePage;
import pageObjects.herokuapp.HomePageItems;

public class HerokuAppTests extends BaseTest {
    HomePage homePage;

    @BeforeMethod
    public void precondition() {
       homePage = new HomePage();
       homePage.open("https://the-internet.herokuapp.com/");
    }

    @Test (priority = 1)
    public void iframeTest() {
        Frames frames = new Frames();
        homePage.clickOnItem(HomePageItems.FRAMES);
        frames.verifyTitleText();
        frames.clickOnItem("iFrame");
        frames.switchToFrame();
        frames.verifyText();
        frames.unSwitchToFrame();
    }

    @Test (priority = 2)
    public void DynamicControlsTest() {
        DynamicControls dynamicControls = new DynamicControls();
        homePage.clickOnItem(HomePageItems.DYNAMIC_CONTROLS);
        dynamicControls.verifyHeaderText();
        dynamicControls.clickOnRemoveBtn();
        dynamicControls.verifyAppearedText();
        dynamicControls.verifyThatCheckboxDisappears();
        dynamicControls.verifyIfDisabled();
        dynamicControls.clickOnDisabledBtn();
        dynamicControls.verifyIfEnabledTextAppears();
        dynamicControls.verifyIfEnabled();
    }
}
