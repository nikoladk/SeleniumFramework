package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testDataTypes.Customer;

public class CheckoutPage {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "billing_first_name")
    private WebElement firstNameTextBox;

    @FindBy(how = How.ID, using = "billing_last_name")
    private WebElement lastNameTextBox;

    @FindBy(how = How.ID, using = "billing_address_1")
    private WebElement addressTextBox;

    @FindBy(how = How.CSS, using = "#billing_email")
    private WebElement emailTextBox;

    @FindBy(how = How.CSS, using = "#billing_phone")
    private WebElement phoneNumberTextBox;

    @FindBy(how = How.CSS, using = "#billing_postcode")
    private WebElement postCodeTextBox;

    @FindBy(how = How.ID, using = "billing_city")
    private WebElement cityTextBox;

    @FindAll(@FindBy(how = How.ID, using = "elect2-billing_country-container"))
    private WebElement countryDropdown;

    @FindAll(@FindBy(how = How.ID, using = "select2-billing_state-container"))
    private WebElement cityDropdown;

    @FindBy(how = How.CSS, using = "#terms.input-checkbox")
    private WebElement termsAndConditionsCheckBox;

    @FindBy(how = How.CSS, using = "#place_order")
    private WebElement placeOrderButton;

    public void setFirstNameTextBox(String firstName) {
       firstNameTextBox.sendKeys(firstName);
    }

    public void setLastNameTextBox(String lastName) {
        lastNameTextBox.sendKeys(lastName);
    }

    public void setAddressTextBox(String address) {
        addressTextBox.sendKeys(address);
    }

    public void setEmailTextBox(String email) {
        emailTextBox.sendKeys(email);
    }

    public void setPhoneNumberTextBox(String phoneNumber) {
        phoneNumberTextBox.sendKeys(phoneNumber);
    }

    public void setPostCodeTextBox(String postCode) {
        postCodeTextBox.sendKeys(postCode);
    }

    public void setCityTextBox(String city) {
        cityTextBox.sendKeys(city);
    }

    public void setCountryDropdown(String country) {
       Select dropdown = new Select(countryDropdown);
        dropdown.selectByValue(country);
    }

    public void setCityDropdown(String city) {
        Select dropdown = new Select(cityDropdown);
        dropdown.selectByValue(city);
    }

    public void checkTermsAndConditions() {
        termsAndConditionsCheckBox.click();
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public void fillPersonalDetails(Customer customer) {
        setFirstNameTextBox(customer.firstName);
        setLastNameTextBox(customer.lastName);
        setAddressTextBox(customer.address.streetAddress);
        setCityTextBox(customer.address.city);
        setCountryDropdown(customer.address.country);
        setEmailTextBox(customer.emailAddress);
        setPhoneNumberTextBox(customer.phoneNumber.home);
        setPostCodeTextBox(customer.address.postCode);
        checkTermsAndConditions();
        setCityDropdown(customer.address.county);
        placeOrder();
    }
}
