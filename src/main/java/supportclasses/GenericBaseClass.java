package supportclasses;

import automationFramework.supportMethods.ReadFile;
import org.openqa.selenium.WebElement;
import utilities.EventHandlingUtility;
import utilities.GetterMethods;
import utilities.VerifyValidationsUtility;
import webdriver.DriverMethods;

import java.io.File;
import java.util.Collection;

public abstract class GenericBaseClass {

    protected static Collection<String> scenario = null;
    protected static String page = null;
    protected static String pack = null;
    public static File file = null;

    protected DriverMethods dm = new DriverMethods();
    protected ReadFile readFile = new ReadFile();
    protected EventHandlingUtility ehandler = new EventHandlingUtility();
    protected VerifyValidationsUtility verify = new VerifyValidationsUtility();
    protected GetterMethods gm = new GetterMethods();
    protected File fileConfig = new File("configuration\\GenericConfig.properties");
    protected File fileUI = new File("configuration\\UIMap.properties");
    protected File fileMsg = new File("configuration\\MessageBundle.properties");

    public static WebElement element;
    public static WebElement clear;
    public static WebElement values;
    public static WebElement close;
    public static WebElement message;
}
