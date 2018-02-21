package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import supportclasses.GenericBaseClass;
import webdriver.AppDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static webdriver.AppDriver.getCurrentDriver;

public class GenericUtility extends GenericBaseClass {

    public void takeScreenshot() throws IOException {
        String school = readFile.readProperty(fileUI, "schoolname");
        String timestamp = getTimeStamp();
        File f = ((TakesScreenshot) AppDriver.getCurrentDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(f, new File(readFile.readProperty(fileConfig, "screenshotpath") + school + File.separator + page + File.separator + page + scenario + timestamp + ".png"));
    }

    private String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    }
}