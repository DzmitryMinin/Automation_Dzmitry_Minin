package cucumber.rabotaby;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rabotaby.HomePage;
import pageObjects.rabotaby.ResultPage;

public class ResultsSteps extends BaseTestSelenide {
    @Given("I open rabota.by")
    public void openHomePage() {
        get(HomePage.class);
    }

    @When("I enter vacancy {string}")
    public void enterVacancy(String vacancy) {
        get(HomePage.class).enterVacancy(vacancy);
    }

    @And("I click search button")
    public void searchVacancy() {
        get(HomePage.class).searchVacancy();
    }

    @Then("I check header match")
    public void checkHeader() {
        get(ResultPage.class).verifyResultHeader();
    }

    @And("I check if results quantity is greater than {int}")
    public void checkResults(Integer qty) {
        get(ResultPage.class).checkResultQty(qty);
    }

    @And("I check if results quantity equals actual quantity")
    public void checkQty() {
        get(ResultPage.class).verifyResultQty();
    }
}
