package utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.picocontainer.annotations.Inject;
import supportclasses.GenericBaseClass;

public class VerifyValidationsUtility {
    @Inject
    GenericBaseClass baseClass;

    private EventHandlingUtility ehandler = new EventHandlingUtility();

    public void validateBlankField(WebElement we, String expected, WebElement msgid) {
        if (we.getAttribute("value").equals(""))
            Assert.assertEquals(expected, msgid.getText());
        System.out.println(msgid.getText());
    }

    public void verifyValidationMessage(String expected, WebElement msgid) {
        Assert.assertEquals(expected, msgid.getText());
        System.out.println(msgid.getText());
    }

    public void verifyCancel(WebElement we) {
        Assert.assertEquals("", we.getAttribute("value"));
        System.out.println("Page Refreshed");
    }

    public void verifyValidationOnMultiSelect(String exp) {
        ehandler.click(baseClass.element);
        ehandler.click(baseClass.clear);
        ehandler.click(baseClass.close);
        Assert.assertTrue(baseClass.message.isDisplayed());
        verifyValidationMessage(exp, baseClass.message);
    }

    void verifyMessageImage(WebElement imgicon, String url, String img) {
        Assert.assertEquals(url + img, imgicon.getAttribute("src"));
        System.out.println(img);
    }

    public void verifyValidationOnMultiSelect(WebElement tilldate, WebElement clr, WebElement tilldatemessage, String tilldate1) {
        ehandler.click(tilldate);
        ehandler.click(clr);
        Assert.assertTrue(tilldatemessage.isDisplayed());
        verifyValidationMessage(tilldate1, tilldatemessage);
    }
}