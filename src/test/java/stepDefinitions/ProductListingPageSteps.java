package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pageObjects.ProductListingPage;

public class ProductListingPageSteps {
    TestContext testContext;
    ProductListingPage productListingPage;

    public ProductListingPageSteps(TestContext context) {
        this.testContext = context;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @When("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() {
        productListingPage.selectProductByNumber(6);
    }

    @And("^select color and size$")
    public void selectColorAndSize() {
        productListingPage.selectColor("nude");
        productListingPage.selectSize("34");
        productListingPage.addToBasket();
        productListingPage.goToCartPage();
    }


}
