package webdriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static webdriver.AppDriver.getCurrentDriver;

public class DriverMethods {

    public void maximizeWindow() throws IOException {
        getCurrentDriver().manage().window().maximize();
    }

    public void getUrl(String url) throws IOException {
        getCurrentDriver().get(url);
    }

    public void switchToParentWindow() throws IOException {
        getCurrentDriver().switchTo().defaultContent();
    }

    public void switchToWindow(int win) throws IOException {
        ArrayList<String>windows = new ArrayList<String>(getCurrentDriver().getWindowHandles());
        getCurrentDriver().switchTo().window(windows.get(win));
    }

    public void waitImplicitly(int time) throws IOException {
        getCurrentDriver().manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

   // public void waitUntil(WebElement webelement, int time) throws IOException {
        //WebDriverWait wait= new WebDriverWait(getCurrentDriver(), time);
        //wait.until(ExpectedConditions.visibilityOf(webelement));
   // }
}