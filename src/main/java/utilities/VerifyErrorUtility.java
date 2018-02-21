package utilities;

import org.junit.Assert;
import org.picocontainer.annotations.Inject;
import supportclasses.GenericBaseClass;
import supportclasses.LogManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static webdriver.AppDriver.getCurrentDriver;

public class VerifyErrorUtility extends GenericBaseClass {
    @Inject
    LogManager lm;
    private GenericUtility utility = new GenericUtility();

    ExcelUtility exc = new ExcelUtility();
    private ArrayList<String> list= new ArrayList<String>();
    private Date date = new Date();
    private int size= scenario.toString().length();
    private String scn= scenario.toString().substring(2, size-1);
    private String message;

    public void verifyPageError() throws IOException {
        try {
            Assert.assertFalse(getCurrentDriver().getPageSource().contains(readFile.readProperty(fileMsg, "pagenotfounderror")));
            dm.switchToParentWindow();
            try {
                //dr.findElement(By.id("defaultSpeechbubbleHeader"));
                //message = dr.findElement(By.id("defaultSpeechbubbleHeader")).getText();
                addValuesInList();
                exc.prepareErrorLog(list);
                utility.takeScreenshot();
            }
            catch (Exception e){
                lm.logger.info(readFile.readProperty(fileMsg, "noerrorfound"));
            }
        }
        catch (Exception e){
            message = readFile.readProperty(fileMsg, "pagenotfounderror");
            addValuesInList();
            exc.prepareErrorLog(list);
            utility.takeScreenshot();
        }
    }

    private void addValuesInList(){
        list.add(date.toString());
        list.add(scn);
        list.add(page);
        list.add(message);
    }
}