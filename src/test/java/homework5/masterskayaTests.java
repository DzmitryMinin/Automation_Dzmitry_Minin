package homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.MainWebDriver.*;

public class masterskayaTests {
    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @AfterTest
    public void shutDown() {
        quit();
    }

    @Test
    public void minPossibleValuesTest() {
        WebElement roomWidth = getWebDriver().findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.CONTROL + "A");
        roomWidth.sendKeys(Keys.BACK_SPACE);
        roomWidth.sendKeys("1");

        WebElement roomHeight = getWebDriver().findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.CONTROL + "A");
        roomHeight.sendKeys(Keys.BACK_SPACE);
        roomHeight.sendKeys("1");

        WebElement lamWidth = getWebDriver().findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.CONTROL + "A");
        lamWidth.sendKeys(Keys.BACK_SPACE);
        lamWidth.sendKeys("100");

        WebElement lamHeight = getWebDriver().findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.CONTROL + "A");
        lamHeight.sendKeys(Keys.BACK_SPACE);
        lamHeight.sendKeys("50");

        WebElement inPack = getWebDriver().findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.CONTROL + "A");
        inPack.sendKeys(Keys.BACK_SPACE);
        inPack.sendKeys("1");

        WebElement inPrice = getWebDriver().findElement(By.name("calc_price"));
        inPrice.sendKeys(Keys.CONTROL + "A");
        inPrice.sendKeys(Keys.BACK_SPACE);
        inPrice.sendKeys("10");

        WebElement bias = getWebDriver().findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.CONTROL + "A");
        bias.sendKeys(Keys.BACK_SPACE);
        bias.sendKeys("1");

        WebElement wallDist = getWebDriver().findElement(By.name("calc_walldist"));
        wallDist.sendKeys(Keys.CONTROL + "A");
        wallDist.sendKeys(Keys.BACK_SPACE);
        wallDist.sendKeys("1");

        Select option2 = new Select(getWebDriver().findElement(By.name("calc_direct")));
        option2.selectByValue("toh");

        clickBtnWhenItsVisible();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='s_lam']/b")).getText(), "1.00");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_count']/b")).getText(), "200");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_packs']/b")).getText(), "200");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_price']/b")).getText(), "10");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_over']/b")).getText(), "0");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_trash']/b")).getText(), "18");
    }

    @Test
    public void maxPossibleValuesTest() {
        WebElement roomWidth = getWebDriver().findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.CONTROL + "A");
        roomWidth.sendKeys(Keys.BACK_SPACE);
        roomWidth.sendKeys("15");

        WebElement roomHeight = getWebDriver().findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.CONTROL + "A");
        roomHeight.sendKeys(Keys.BACK_SPACE);
        roomHeight.sendKeys("10");

        WebElement lamWidth = getWebDriver().findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.CONTROL + "A");
        lamWidth.sendKeys(Keys.BACK_SPACE);
        lamWidth.sendKeys("5000");

        WebElement lamHeight = getWebDriver().findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.CONTROL + "A");
        lamHeight.sendKeys(Keys.BACK_SPACE);
        lamHeight.sendKeys("1000");

        WebElement inPack = getWebDriver().findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.CONTROL + "A");
        inPack.sendKeys(Keys.BACK_SPACE);
        inPack.sendKeys("100");

        WebElement inPrice = getWebDriver().findElement(By.name("calc_price"));
        inPrice.sendKeys(Keys.CONTROL + "A");
        inPrice.sendKeys(Keys.BACK_SPACE);
        inPrice.sendKeys("1000000");

        WebElement bias = getWebDriver().findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.CONTROL + "A");
        bias.sendKeys(Keys.BACK_SPACE);
        bias.sendKeys("650");

        WebElement wallDist = getWebDriver().findElement(By.name("calc_walldist"));
        wallDist.sendKeys(Keys.CONTROL + "A");
        wallDist.sendKeys(Keys.BACK_SPACE);
        wallDist.sendKeys("100");

        Select option1 = new Select(getWebDriver().findElement(By.name("calc_direct")));
        option1.selectByValue("tow");

        clickBtnWhenItsVisible();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='s_lam']/b")).getText(), "145.04");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_count']/b")).getText(), "31");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_packs']/b")).getText(), "1");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_price']/b")).getText(), "500000000");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_over']/b")).getText(), "69");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_trash']/b")).getText(), "4");
    }

    @Test
    public void decimalLengthAndWidthTest() {
        WebElement roomWidth = getWebDriver().findElement(By.name("calc_roomwidth"));
        roomWidth.sendKeys(Keys.CONTROL + "A");
        roomWidth.sendKeys(Keys.BACK_SPACE);
        roomWidth.sendKeys("6.222");

        WebElement roomHeight = getWebDriver().findElement(By.name("calc_roomheight"));
        roomHeight.sendKeys(Keys.CONTROL + "A");
        roomHeight.sendKeys(Keys.BACK_SPACE);
        roomHeight.sendKeys("5.999");

        WebElement lamWidth = getWebDriver().findElement(By.name("calc_lamwidth"));
        lamWidth.sendKeys(Keys.CONTROL + "A");
        lamWidth.sendKeys(Keys.BACK_SPACE);
        lamWidth.sendKeys("1300");

        WebElement lamHeight = getWebDriver().findElement(By.name("calc_lamheight"));
        lamHeight.sendKeys(Keys.CONTROL + "A");
        lamHeight.sendKeys(Keys.BACK_SPACE);
        lamHeight.sendKeys("195");

        WebElement inPack = getWebDriver().findElement(By.name("calc_inpack"));
        inPack.sendKeys(Keys.CONTROL + "A");
        inPack.sendKeys(Keys.BACK_SPACE);
        inPack.sendKeys("12");

        WebElement inPrice = getWebDriver().findElement(By.name("calc_price"));
        inPrice.sendKeys(Keys.CONTROL + "A");
        inPrice.sendKeys(Keys.BACK_SPACE);
        inPrice.sendKeys("519");

        WebElement bias = getWebDriver().findElement(By.name("calc_bias"));
        bias.sendKeys(Keys.CONTROL + "A");
        bias.sendKeys(Keys.BACK_SPACE);
        bias.sendKeys("288");

        WebElement wallDist = getWebDriver().findElement(By.name("calc_walldist"));
        wallDist.sendKeys(Keys.CONTROL + "A");
        wallDist.sendKeys(Keys.BACK_SPACE);
        wallDist.sendKeys("10");

        clickBtnWhenItsVisible();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='s_lam']/b")).getText(), "37.08");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_count']/b")).getText(), "155");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_packs']/b")).getText(), "13");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_price']/b")).getText(), "20524");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_over']/b")).getText(), "1");
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//span[@id='l_trash']/b")).getText(), "24");
    }
}
