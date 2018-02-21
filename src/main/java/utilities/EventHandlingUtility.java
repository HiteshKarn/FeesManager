package utilities;

import automationFramework.supportMethods.ReadFile;
import automationFramework.supportMethods.UIMap;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.picocontainer.annotations.Inject;
import supportclasses.GenericBaseClass;
import webdriver.DriverMethods;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static webdriver.AppDriver.getCurrentDriver;

public class EventHandlingUtility {
    @Inject
    GenericBaseClass baseClass;

    private File fileUI = new File("configuration\\UIMap.properties");
    private ReadFile readFile = new ReadFile();
    private DriverMethods dm = new DriverMethods();
    private StringBuilder value = new StringBuilder();

    public void openFrame(WebElement menu, WebElement link, WebElement frame) throws IOException {
        moveToElement(menu);
        clickMenuItem(link);
        switchToFrame(frame);
    }

    public void moveToElement(WebElement menuItem) throws IOException {
        new Actions(getCurrentDriver()).moveToElement(menuItem).build().perform();
    }

    private void clickMenuItem(WebElement link) throws IOException {
        new Actions(getCurrentDriver()).moveToElement(link).click().perform();
    }

    private void switchToFrame(WebElement frame) throws IOException {
        getCurrentDriver().switchTo().frame(frame);
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isElementDisplayed(WebElement element) {
        if (element.isDisplayed())
            return true;
        else
            return false;
    }

    public void clearValue(WebElement element) {
        element.clear();
    }

    public void enterText(WebElement textfield, String text) {
        textfield.sendKeys(text);
    }

    public void pressEnter(WebElement textfield) throws InterruptedException {
        textfield.sendKeys(Keys.ENTER);
        Thread.sleep(200);
    }

    public void pressDownArrow(WebElement textfield) throws InterruptedException {
        textfield.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(200);
    }

    public void enterText(WebElement textfield, int n) {
        for (int i = 0; i < n; i++) {
            textfield.sendKeys("a");
            value.append("a");
        }
    }

    public void verifyString() throws IOException {
        Assert.assertTrue(getCurrentDriver().getPageSource().contains(value));
        System.out.println("Value Saved");
    }

    //select first record in table
    void selectRecord(WebElement table, WebElement select) {
        List<WebElement> cells = table.findElements(By.tagName("td"));
        if (cells.size() > 1) {
            for (WebElement cell : cells) {
                select.click();
                break;
            }
        } else
            System.out.println("No Record Found");
    }

    //click particular cell of table
    private void selectValueFromTable(String value) throws IOException {
        List<WebElement> cells = new UIMap().getCell();
        for (WebElement cell : cells) {
            if (cell.getText().equals(value)) {
                cell.click();
                break;
            }
        }
    }

    public void selectByVisibleText(WebElement element, String text) throws InterruptedException {
        new Select(element).selectByVisibleText(text);
        Thread.sleep(100);
    }

    public void selectByIndex(WebElement element, int index) throws InterruptedException {
        new Select(element).selectByIndex(index);
        Thread.sleep(500);
    }

    public void selectDate(WebElement date, String mm, String yy, String dd) throws IOException, InterruptedException {
        click(date);
        Thread.sleep(200);
        //dm.waitUntil(new UIMap().getMonthPicker(), 200);
        selectByVisibleText(new UIMap().getMonthPicker(), mm);
      //  dm.waitUntil(new UIMap().getYearPicker(), 20);
        Thread.sleep(200);
        selectByVisibleText(new UIMap().getYearPicker(), yy);
      //  dm.waitUntil(new UIMap().getDayPicker(), 200);
        selectValueFromTable(dd);
        Thread.sleep(500);
    }

    //select 1st value in multiselect list
    public void selectValue() throws IOException {
        click(baseClass.element);
        click(baseClass.clear);
        List<WebElement> options = readFile.getElements(fileUI, baseClass.values, "tablelist");
        if (options.isEmpty())
            System.out.println("No Value Present");
        else
            click(options.get(0));
        click(baseClass.close);
    }

    public void getList(List<WebElement> elements) {
        HashMap<String, Integer> radioList = new HashMap<String, Integer>();
        for (WebElement emt : elements) {
            String id = emt.getAttribute("id");
            System.out.println(emt.getText());
        }
    }

    public void clickRadioButton(List<WebElement> elements, String value) {
        for (WebElement element : elements) {
            if (element.getAttribute("value").equals(value))
                element.click();
        }
    }
}