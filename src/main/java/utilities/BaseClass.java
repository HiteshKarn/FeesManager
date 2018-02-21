package utilities;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import supportclasses.GenericBaseClass;

import java.io.IOException;

public abstract class BaseClass extends GenericBaseClass {

    @FindBy(xpath = "//input[@value='Save']") private WebElement save;
    @FindBy(xpath = "//input[@value='View']") private WebElement view;
    @FindBy(xpath = "//input[@value='Modify']") private WebElement modify;
    @FindBy(xpath = "//input[@value='Delete']") private WebElement delete;
    @FindBy(xpath = "//input[@value='Cancel']") private WebElement cancel;
    @FindAll({@FindBy(id = "example"), @FindBy(id = "example1")}) private WebElement table;

    public void clickSave(){
        ehandler.click(save);
    }

    public void clickView() {
        ehandler.click(view);
    }

    public void selectRecord() throws IOException {
        ehandler.selectRecord(table, new UIMap().getSelect());
    }

    public void clickModify() {
        ehandler.click(modify);
    }

    public void clickYes() throws IOException {
        ehandler.click(new UIMap().getYes());
    }

    public void clickNo() throws IOException {
        ehandler.click(new UIMap().getNo());
    }

    public void clickDelete() {
        ehandler.click(delete);
    }

    public void clickCancel(){
        ehandler.click(cancel);
    }

    protected String getMessage() throws IOException {
        return readFile.readProperty(fileUI, "message");
    }

    public void verifyModifyMessage() throws IOException {
        dm.switchToParentWindow();
        verify.verifyValidationMessage(readFile.readProperty(file, "modifymessage"), new UIMap().getServerMessage());
    }

    public void verifyDuplicateValue() throws IOException {
        dm.switchToParentWindow();
        verify.verifyValidationMessage(readFile.readProperty(file, "duplicatevaluemessage"), new UIMap().getServerMessage());
    }

    public void verifySaveMessage() throws IOException {
        dm.switchToParentWindow();
        verify.verifyValidationMessage(readFile.readProperty(file, "savemessage"),new UIMap().getServerMessage());
    }

    public void verifyDeleteMessage() throws IOException {
        dm.switchToParentWindow();
        verify.verifyValidationMessage(readFile.readProperty(file, "deletemessage"), new UIMap().getServerMessage());
    }

    public void validateNumericValue() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(file,"numbervalidationmessage"), readFile.getElement("numbervalidation"));
    }

    public void validateLength() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(file,"characterlengthvalidationmessage"), readFile.getElement("lengthvalidation"));
    }

    public void verifySuccessMessageImage() throws IOException {
        verify.verifyMessageImage(new UIMap().getMessageImage(), readFile.readProperty(fileUI, "url"), readFile.readProperty(fileUI, "successimage"));
    }

    public void verifyWarningMessageImage() throws IOException {
        verify.verifyMessageImage(new UIMap().getMessageImage(), readFile.readProperty(fileUI, "url"), readFile.readProperty(fileUI, "warningimage"));
    }

    public void verifyErrorMessageImage() throws IOException {
        verify.verifyMessageImage(new UIMap().getMessageImage(), readFile.readProperty(fileUI, "url"), readFile.readProperty(fileUI, "errorimage"));
    }
}