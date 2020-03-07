package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import  cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;

public class Hooks {
    TestContext testContext;

    public Hooks(TestContext context) {
        this.testContext = context;
    }

    @Before
    public void setUp() {

    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if(scenario.isFailed()) {
            String screenshotName = scenario.getName().replaceAll(" ", "_" );
            try {
                File sourcePath = ((TakesScreenshot)testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.FILE);

                File destinationPath = new File(System.getProperty("user.dir")+ "/target/cucumber-reports/screenshots/" + screenshotName + ".png") ;

            
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
        }

    }
    @After(order = 0)
    public void tearDown() {
        testContext.getWebDriverManager().closeDriver();
    }
}
