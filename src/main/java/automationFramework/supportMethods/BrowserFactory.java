package automationFramework.supportMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.picocontainer.annotations.Inject;
import supportclasses.GenericBaseClass;
import supportclasses.LogManager;
import webdriver.AppDriver;

import java.io.IOException;
import java.lang.String;

import static webdriver.AppDriver.driver;

public class BrowserFactory extends GenericBaseClass {
    @Inject
    LogManager lm = new LogManager();

    public WebDriver getBrowser(String browser) throws IOException {

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\chromedriver_win32\\chromedriver.exe");
                AppDriver.driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(readFile.readProperty(fileConfig, "firefoxdriver"), readFile.readProperty(fileConfig, "firefoxdriverpath"));
                AppDriver.driver = new FirefoxDriver();
                break;
            case "ie":
                System.setProperty(readFile.readProperty(fileConfig, "iedriver"), readFile.readProperty(fileConfig, "iedriverpath"));
                AppDriver.driver = new InternetExplorerDriver();
                break;
            default:
                lm.logger.info(page + ":" + readFile.readProperty(fileMsg, "browsernotdefined"));
        }
        return AppDriver.driver;
    }
}