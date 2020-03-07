package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import pageObjects.HomePage;

public class HomePageSteps {
    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {
    this.testContext = context;
    homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^user is on Home Page$")
    public void userIsOnHomePage(){
        homePage.navigateToHomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchFor(String item) {
        homePage.performSearch("shirt");
    }
}
