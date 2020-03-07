package pageObjects;

import gherkin.lexer.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductListingPage {
    WebDriver driver;
    public ProductListingPage(WebDriver driver) {
       this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindAll(@FindBy(how = How.CSS, using = ".noo-product-inner"))
    private List<WebElement> productList;

    @FindBy(how = How.CSS, using = "button.single_add_to_cart_button")
    private WebElement addToCardButton;

    @FindBy(how = How.ID, using = "pa_color")
    private WebElement colorDropDown;

    @FindBy(how = How.ID, using = "pa_size")
    private WebElement sizeDropDown;

    @FindBy(how = How.ID, using = "nav-menu-item-cart")
    private WebElement cartPageButton;

    public void selectProductByNumber(int productNumber) {
        productList.get(productNumber).click();
    }

    public void addToBasket() {
        addToCardButton.click();
    }

    public void selectColor(String color) {
        Select dropdown = new Select(colorDropDown);
        dropdown.selectByValue(color);
    }

    public void selectSize(String size) {
        Select dropdown = new Select(sizeDropDown);
        dropdown.selectByValue(size);
    }

    public void goToCartPage() {
       cartPageButton.click();
    }
}
