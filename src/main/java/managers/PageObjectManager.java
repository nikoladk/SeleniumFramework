package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class PageObjectManager {
    private WebDriver driver;
    private ProductListingPage productListingPage;
    private HomePage homePage;
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    public PageObjectManager (WebDriver driver) {
        this.driver = driver;
    }

   public HomePage getHomePage() {
        return (homePage == null) ? new HomePage(driver) : homePage;
   }

   public ProductListingPage getProductListingPage() {
        return (productListingPage == null) ? new ProductListingPage(driver) : productListingPage;
   }

   public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? new CheckoutPage(driver) : checkoutPage;
   }

   public CartPage getCartPage() {
        return (cartPage == null) ? new CartPage(driver) : cartPage;
   }
}
