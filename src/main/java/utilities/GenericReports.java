package utilities;

import automationFramework.supportMethods.UIMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import supportclasses.GenericBaseClass;
import webdriver.DriverMethods;

import java.io.IOException;

public abstract class GenericReports extends GenericBaseClass {

    @FindBy(id = "ContentPlaceHolder1_txtDateFrom_TextBox")
    protected WebElement fromdate;
    @FindBy(id = "ContentPlaceHolder1_txtdateTo_TextBox")
    private WebElement todate;
    @FindBy(id = "ContentPlaceHolder1_chkReceiptNoRange")
    private WebElement receiptnorange;
    @FindBy(id = "ContentPlaceHolder1_txtFrom_TextBox")
    private WebElement receiptfrom;
    @FindBy(id = "ContentPlaceHolder1_txtTo_TextBox")
    private WebElement receiptto;
    @FindBy(xpath = "//input[@value='Show']")
    private WebElement show;
    @FindBy(className = "datepick-clear")
    protected WebElement clr;
    @FindBy(className = "datepick-close")
    private WebElement cls;

    private static final String INSTALLMENT = "installment";

    private void getClassElements() throws IOException {
        element = readFile.getElement("class");
        clear = readFile.getElement("classclear");
        values = readFile.getElement("classvalueslist");
        close = readFile.getElement("classclose");
        message = readFile.getElement("classmessage");
    }

    private void getEntryModeElements() throws IOException {
        element = readFile.getElement("entrymode");
        clear = readFile.getElement("entrymodeclear");
        values = readFile.getElement("entrymodevalueslist");
        close = readFile.getElement("entrymodeclose");
        message = readFile.getElement("entrymodemessage");
    }

    private void getPayModeElements() throws IOException {
        element = readFile.getElement("paymode");
        clear = readFile.getElement("paymodeclear");
        values = readFile.getElement("paymodevalueslist");
        close = readFile.getElement("paymodeclose");
        message = readFile.getElement("paymodemessage");
    }

    private void getHeadElements() throws IOException {
        element = readFile.getElement("head");
        clear = readFile.getElement("headclear");
        values = readFile.getElement("headvalueslist");
        close = readFile.getElement("headclose");
        message = readFile.getElement("headmessage");
    }

    private void getInstallmentElements() throws IOException {
        element = readFile.getElement(INSTALLMENT);
        clear = readFile.getElement("installmentclear");
        values = readFile.getElement("installmentvalueslist");
        close = readFile.getElement("installmentclose");
        message = readFile.getElement("installmentmessage");
    }

    public void validateClass() throws IOException {
        getClassElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, "cls"));
    }

    public void validateEntryMode() throws IOException {
        getEntryModeElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, "entrymode"));
    }

    public void validatePayMode() throws IOException {
        getPayModeElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, "paymode"));
    }

    public void validateHead() throws IOException {
        getHeadElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, "head"));
    }

    public void validateInstallment() throws IOException {
        getInstallmentElements();
        verify.verifyValidationOnMultiSelect(readFile.readProperty(fileUI, INSTALLMENT));
    }

    public void selectSchool(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("school"), index);
    }

    public void selectWing(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("wing"), index);
    }

    public void selectClass() throws IOException {
        getClassElements();
        ehandler.selectValue();
    }

    public void selectClass(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("class"), index);
    }

    public void selectBoard(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("board"), index);
    }

    public void selectSection(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("section"), index);
    }

    public void selectInstallment() throws IOException {
        getInstallmentElements();
        ehandler.selectValue();
    }

    public void selectInstallment(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement(INSTALLMENT), index);
    }

    public void selectInstallment(String inst) throws IOException, InterruptedException {
        ehandler.selectByVisibleText(readFile.getElement(INSTALLMENT), inst);
    }

    public void selectEntryMode() throws IOException {
        getEntryModeElements();
        ehandler.selectValue();
    }

    public void selectPayMode() throws IOException {
        getPayModeElements();
        ehandler.selectValue();
    }

    public void selectHead() throws IOException {
        getHeadElements();
        ehandler.selectValue();
    }

    public void selectFeeType(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("feetype"), index);
    }

    public void selectUser(int index) throws IOException, InterruptedException {
        ehandler.selectByIndex(readFile.getElement("user"), index);
    }

    public void selectFromDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(fromdate, mm, yy, dd);
    }

    public void selectToDate(String mm, String yy, String dd) throws IOException, InterruptedException {
        ehandler.selectDate(todate, mm, yy, dd);
    }

    public void validateDateFrom() throws IOException {
        verify.verifyValidationOnMultiSelect(fromdate, clr, readFile.getElement("datefrommessage"), readFile.readProperty(fileUI, "datefrom"));
    }

    public void validateToDate() throws IOException {
        verify.verifyValidationOnMultiSelect(todate, clr, readFile.getElement("datetomessage"), readFile.readProperty(fileUI, "dateto"));
    }

    public void validateTillDate() throws IOException {
        verify.verifyValidationOnMultiSelect(todate, clr, readFile.getElement("tilldatemessage"), readFile.readProperty(fileUI, "tilldate"));
    }

    public void clickReceiptRange() throws IOException {
        //new DriverMethods().waitUntil(receiptnorange, 1000);
        ehandler.click(receiptnorange);
    }

    public void clickButton(String value) throws IOException {
        ehandler.clickRadioButton(readFile.getElements("radiobuttongroup"), value);
    }

    public void clickSettlementDate() throws IOException {
        ehandler.click(readFile.getElement("settlementdate"));
    }

    public void clickChequeClearanceDate() throws IOException {
        ehandler.click(readFile.getElement("chequeclearancedate"));
    }

    public void clickDateRange() throws IOException {
        ehandler.click(readFile.getElement("daterange"));
    }

    public void enterReceiptFrom(String rfrom) {
        ehandler.enterText(receiptfrom, rfrom);
    }

    public void enterReceiptFrom(int n) {
        ehandler.enterText(receiptfrom, n);
    }

    public void enterReceiptTo(String rto) {
        ehandler.enterText(receiptto, rto);
    }

    public void enterReceiptTo(int n) {
        ehandler.enterText(receiptto, n);
    }

    public void pressEnterInReceiptFrom() throws InterruptedException {
        ehandler.pressEnter(receiptfrom);
    }

    public void pressEnterReceiptTo() throws InterruptedException {
        ehandler.pressEnter(receiptto);
    }

    public void validateReceiptFromMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receiptnomessage"), new UIMap().getReceiptFrom());
    }

    public void validateReceiptToMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receiptnomessage"), new UIMap().getReceiptTo());
    }

    public void validateReceiptFromLength() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receiptnolengthmessage"), new UIMap().getReceiptFromLength());
    }

    public void validateReceiptToLength() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receiptnolengthmessage"), new UIMap().getReceiptToLength());
    }

    public void validateDateAlertMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "datemessage"), new UIMap().getPopUpMessage());
    }

    public void validateBlankReceiptFromAlertMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receiptfromblankmessage"), new UIMap().getPopUpMessage());
    }

    public void validateBlankReceiptToAlertMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "receipttoblankmessage"), new UIMap().getPopUpMessage());
    }

    public void validateInvalidReceiptRangeAlertMessage() throws IOException {
        verify.verifyValidationMessage(readFile.readProperty(fileUI, "invalidreceiptrangemessage"), new UIMap().getPopUpMessage());
    }

    public void clickShow() {
        ehandler.click(show);
    }
}