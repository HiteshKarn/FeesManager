package automationFramework.supportMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import supportclasses.GenericBaseClass;
import webdriver.AppDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import static supportclasses.GenericBaseClass.file;
import static webdriver.AppDriver.getCurrentDriver;

public class ReadFile implements GetLocators {
    private Properties properties = new Properties();

    private FileInputStream readFile(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public String readProperty(File file, String key) throws IOException {
        String value = null;
        if (file.exists()) {
            properties.load(readFile(file));
            value = properties.getProperty(key);
        }
        return value;
    }

    public WebElement getElement(String element) throws IOException {

        String locator = readProperty(GenericBaseClass.file, element + "type");
        String value = readProperty(GenericBaseClass.file, element);
        WebElement webelement = null;

        if (locator.equalsIgnoreCase(ID))
            webelement = AppDriver.getCurrentDriver().findElement(By.id(value));
        if (locator.equalsIgnoreCase(NAME))
            webelement = AppDriver.getCurrentDriver().findElement(By.name(value));
        if (locator.equalsIgnoreCase(XPATH))
            webelement = AppDriver.getCurrentDriver().findElement(By.xpath(value));
        if (locator.equalsIgnoreCase(LINKTEXT))
            webelement = AppDriver.getCurrentDriver().findElement(By.linkText(value));
        if (locator.equalsIgnoreCase(TAGNAME))
            webelement = AppDriver.getCurrentDriver().findElement(By.tagName(value));
        if (locator.equalsIgnoreCase(CSSSELECTOR))
            webelement = AppDriver.getCurrentDriver().findElement(By.cssSelector(value));
        if (locator.equalsIgnoreCase(CLASSNAME))
            webelement = AppDriver.getCurrentDriver().findElement(By.className(value));

        return webelement;
    }

    public List<WebElement> getElements(String element) throws IOException {

        String locator = readProperty(GenericBaseClass.file, element + "type");
        String value = readProperty(GenericBaseClass.file, element);
        List<WebElement> webelement = null;

        if (locator.equals(ID))
            webelement = AppDriver.getCurrentDriver().findElements(By.id(value));
        if (locator.equals(NAME))
            webelement = AppDriver.getCurrentDriver().findElements(By.name(value));
        if (locator.equals(XPATH))
            webelement = AppDriver.getCurrentDriver().findElements(By.xpath(value));
        if (locator.equalsIgnoreCase(LINKTEXT))
            webelement = AppDriver.getCurrentDriver().findElements(By.linkText(value));
        if (locator.equalsIgnoreCase(TAGNAME))
            webelement = AppDriver.getCurrentDriver().findElements(By.tagName(value));
        if (locator.equalsIgnoreCase(CSSSELECTOR))
            webelement = AppDriver.getCurrentDriver().findElements(By.cssSelector(value));
        if (locator.equalsIgnoreCase(CLASSNAME))
            webelement = AppDriver.getCurrentDriver().findElements(By.className(value));

        return webelement;
    }

    //get all elements of a list or a table
    public List<WebElement> getElements(File file, WebElement ele, String element) throws IOException {
        String value = readProperty(file, element);
        List<WebElement> webelement = null;
        webelement = ele.findElements(By.tagName(value));
        return webelement;
    }
}