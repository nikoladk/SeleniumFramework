package pageObjects;

import dataProviders.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToHomePage() {
        driver.navigate().to(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
    }

    public void performSearch(String item){
        driver.navigate().to(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl() + "/?s=" + item + "&post_type=product");
    }


}
