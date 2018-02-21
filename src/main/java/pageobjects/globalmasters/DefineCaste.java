package pageobjects.globalmasters;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import supportclasses.GenericBaseClass;
import utilities.BaseClass;

import java.io.IOException;

public class DefineCaste extends BaseClass {
    @FindBy(xpath = "//*[contains(text(),'Define Caste')]")
    private WebElement link;
    @FindBy(id = "Define Caste")
    private WebElement frame;

    public DefineCaste(WebDriver d) {
        GenericBaseClass.page = this.getClass().getSimpleName();
        GenericBaseClass.pack = gm.getPackage(this.getClass().getPackage().getName());
        GenericBaseClass.file = gm.getFilePath(GenericBaseClass.page, GenericBaseClass.pack);
        PageFactory.initElements(d, this);
    }

    public void openDefineCaste() throws IOException {
        ehandler.openFrame(new UIMap().getGlobalMastersMenu(), link, frame);
    }

    public void enterCasteName(String cname) throws IOException {
        ehandler.enterText(readFile.getElement("castename"), cname);
    }

    public void enterCasteName(int n) throws IOException {
        ehandler.enterText(readFile.getElement("castename"), n);
    }

    public void validateBlank() throws IOException {
        verify.validateBlankField(readFile.getElement("castename"), readFile.readProperty(GenericBaseClass.file, "blankvalidationmessage"), readFile.getElement("blankvalidation"));
    }

    public void verifyCancel() throws IOException {
        verify.verifyCancel(readFile.getElement("castename"));
    }
}
