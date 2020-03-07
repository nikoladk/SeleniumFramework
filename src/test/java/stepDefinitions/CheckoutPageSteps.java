package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import pageObjects.CheckoutPage;
import testDataTypes.Customer;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext context) {
        this.testContext = context;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @And("^enter (.*) details on checkout page$")
    public void enterPersonalDetails(String customerName) {
        Customer customer = FileReaderManager.getInstance().getJsonReader().getCustomerByName(customerName);
        checkoutPage.fillPersonalDetails(customer);

    }

    @When("^select same delivery address$")
    public void selectSameDeliveryAddress() {

    }

    @When("^select payment method as \"([^\"]*)\" payment$")
    public void selectPaymentMethod() {

    }

    @When("^place the order$")
    public void placeOrder() {

    }
}
