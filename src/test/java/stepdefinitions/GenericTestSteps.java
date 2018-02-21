package stepdefinitions;

import automationFramework.supportMethods.ReadFile;
import automationFramework.supportMethods.UIMap;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.EventHandlingUtility;
import webdriver.DriverMethods;

import java.io.File;

public class GenericTestSteps {

    private File file = new File("configuration\\UIMap.properties");
    ReadFile readfile = new ReadFile();
    DriverMethods dm = new DriverMethods();
    EventHandlingUtility event = new EventHandlingUtility();

    @Given("^for url$")
    public void forUrl() throws Throwable {
        dm.getUrl(readfile.readProperty(file, "url"));

    }

    @When("^user enter username and password$")
    public void userEnterUsernameAndPassword() throws Throwable {
        event.enterText(new UIMap().getUsername(), readfile.readProperty(file, "login"));
        event.enterText(new UIMap().getPassword(), readfile.readProperty(file, "pwd"));

    }

    @And("^click sign in to open erp home page$")
    public void clickSignInToOpenErpHomePage() throws Throwable {
        event.click(new UIMap().getSignIn());

    }

    @Then("^user click fee manager logo$")
    public void userClickFeeManagerLogo() throws Throwable {
        try {
            if (event.isElementDisplayed(new UIMap().getFeeLogo()))
                event.click(new UIMap().getFeeLogo());
        } catch (Exception e) {
            if (event.isElementDisplayed(new UIMap().getFeeLogoo()))
                event.click(new UIMap().getFeeLogoo());
            dm.switchToWindow(1);
        }
    }
}
