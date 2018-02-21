package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.globalmasters.DefineCaste;

import static webdriver.AppDriver.driver;

public class TestStep {
    @When("^user open define caste page$")
    public void userOpenDefineCastePage() throws Throwable {
        new DefineCaste(driver).openDefineCaste();
    }

    @And("^click save on define caste page$")
    public void clickSaveOnDefineCastePage() throws Throwable {
      new DefineCaste(driver).clickSave();
    }

    @Then("^verify blank field on define caste page$")
    public void verifyBlankFieldOnDefineCastePage() throws Throwable {
     new DefineCaste(driver).validateBlank();
    }

    @And("^enter caste as \"([^\"]*)\"$")
    public void enterCasteAs(String arg1) throws Throwable {
    new DefineCaste(driver).enterCasteName(arg1);
    }

    @Then("^verify numeric data on define caste page$")
    public void verifyNumericDataOnDefineCastePage() throws Throwable {
     new DefineCaste(driver).validateNumericValue();
    }

    @Then("^verify alphanumeric data on define caste page$")
    public void verifyAlphanumericDataOnDefineCastePage() throws Throwable {
    new DefineCaste(driver).validateNumericValue();
    }

    @And("^enter \"([^\"]*)\" characters in caste$")
    public void enterCharactersInCaste(String arg1) throws Throwable {
    new DefineCaste(driver).enterCasteName(arg1);

    }

    @Then("^verify the saved value on define caste page$")
    public void verifyTheSavedValueOnDefineCastePage() throws Throwable {
    new DefineCaste(driver).verifySaveMessage();
    }

    @Then("^verify caste length on define caste page$")
    public void verifyCasteLengthOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).validateLength();
    }

    @Then("^verify duplicate value on define caste page$")
    public void verifyDuplicateValueOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).verifyDuplicateValue();
        new DefineCaste(driver).verifyWarningMessageImage();
    }

    @Then("^verify save message on define caste page$")
    public void verifySaveMessageOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).verifySaveMessage();
        new DefineCaste(driver).verifySuccessMessageImage();
    }

    @And("^click cancel on define caste page$")
    public void clickCancelOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).clickCancel();
    }

    @Then("^verify cancel on define caste page$")
    public void verifyCancelOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).verifyCancel();
    }

    @And("^select record on define caste page$")
    public void selectRecordOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).clickView();
        new DefineCaste(driver).selectRecord();
    }

    @And("^delete record on define caste page$")
    public void deleteRecordOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).clickDelete();
        new DefineCaste(driver).clickYes();
    }

    @Then("^verify delete message on define caste page$")
    public void verifyDeleteMessageOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).verifyDeleteMessage();
        new DefineCaste(driver).verifySuccessMessageImage();
    }

    @And("^modify record on define caste page$")
    public void modifyRecordOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).clickModify();
        new DefineCaste(driver).clickYes();
    }

    @Then("^verify modify message on define caste page$")
    public void verifyModifyMessageOnDefineCastePage() throws Throwable {
        new DefineCaste(driver).verifyModifyMessage();
        new DefineCaste(driver).verifySuccessMessageImage();
    }
}
