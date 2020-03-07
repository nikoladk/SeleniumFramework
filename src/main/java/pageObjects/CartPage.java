package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
       this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    @FindBy(how = How.CSS, using = ".checkout-button.alt")
    private WebElement checkoutButton;

    public void goToCheckoutPage() {
        checkoutButton.click();
    }

}
