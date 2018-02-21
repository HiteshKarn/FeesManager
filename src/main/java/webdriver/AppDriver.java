package webdriver;

import automationFramework.supportMethods.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class AppDriver {
    public static WebDriver driver;

    private AppDriver(){
        throw new IllegalStateException();
    }

    public static WebDriver getCurrentDriver() throws IOException {
        BrowserFactory bfactory = new BrowserFactory();
        if (driver == null)
            driver = bfactory.getBrowser("chrome");
        return driver;
    }
}