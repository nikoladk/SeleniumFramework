package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.CartPage;

public class CartPageSteps {
    TestContext testContext;
    CartPage cartPage;

    public CartPageSteps(TestContext context) {
        this.testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @When("^moves to checkout from mini cart$")
    public void movesToCheckoutPage() {
        cartPage.goToCheckoutPage();
    }
}
