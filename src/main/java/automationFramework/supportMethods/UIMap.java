package automationFramework.supportMethods;

import org.openqa.selenium.WebElement;
import supportclasses.GenericBaseClass;

import java.io.IOException;
import java.util.List;

public class UIMap extends GenericBaseClass {

    public UIMap() throws IOException {
        page = this.getClass().getSimpleName();
        file = gm.getFilePath(page);
    }

    public WebElement getUsername() throws IOException {
        return readFile.getElement("username");
    }

    public WebElement getPassword() throws IOException {
        return readFile.getElement("password");
    }

    public WebElement getSignIn() throws IOException {
        return readFile.getElement("signin");
    }

    public WebElement getFeeLogo() throws IOException {
        return readFile.getElement("feemanagerlogo");
    }

    public WebElement getFeeLogoo() throws IOException {
        return readFile.getElement("feemanagerlogoo");
    }

    public WebElement getGlobalMastersMenu() throws IOException {
        return readFile.getElement("globalmastersmenu");
    }

    public WebElement getTransactionReportMenu() throws IOException {
        return readFile.getElement("transactionreportmenu");
    }

    public WebElement getCollectionsSubMenu() throws IOException {
        return readFile.getElement("collectionsubmenu");
    }

    public WebElement getAmountWithoutStructureReportsSubMenu() throws IOException {
        return readFile.getElement("amountwithoutstructurereportssubmenu");
    }

    public WebElement getFeeLedgerReportsSubmenu() throws IOException {
        return readFile.getElement("feeledgerreportssubmenu");
    }

    public WebElement getCancelledReceiptReportsSubmenu() throws IOException {
        return readFile.getElement("cancelledreceiptreportssubmenu");
    }

    public WebElement getReconcileReportsSubMenu() throws IOException {
        return readFile.getElement("reconcilereportssubmenu");
    }

    public WebElement getChequeReportsSubmenu() throws IOException {
        return readFile.getElement("chequereportssubmenu");
    }

    public WebElement getConcessionReportsSubMenu() throws IOException {
        return readFile.getElement("concessionreportssubmenu");
    }

    public WebElement getDefaulterReportsSubMenu() throws IOException {
        return readFile.getElement("defaulterreportssubmenu");
    }

    public WebElement getReportsMenu() throws IOException {
        return readFile.getElement("reportsmenu");
    }

    public WebElement getPopUpMessage() throws IOException {
        return readFile.getElement("popupmessage");
    }

    public WebElement getReceiptFrom() throws IOException {
        return readFile.getElement("receiptfrom");
    }

    public WebElement getReceiptTo() throws IOException {
        return readFile.getElement("receiptto");
    }

    public WebElement getReceiptFromLength() throws IOException {
        return readFile.getElement("receiptfromlength");
    }

    public WebElement getReceiptToLength() throws IOException {
        return readFile.getElement("receipttolength");
    }

    public WebElement getMessageImage() throws IOException {
        return readFile.getElement("messageimage");
    }

    public WebElement getSelect() throws IOException {
        return readFile.getElement("select");
    }

    public WebElement getYes() throws IOException {
        return readFile.getElement("yes");
    }

    public WebElement getNo() throws IOException {
        return readFile.getElement("no");
    }

    public WebElement getServerMessage() throws IOException {
        return readFile.getElement("servermessage");
    }

    public WebElement getTransportReportSubMenu() throws IOException {
        return readFile.getElement("transportreportsubmenu");
    }

    public WebElement getMonthPicker() throws IOException {
        return readFile.getElement("monthpicker");
    }

    public WebElement getYearPicker() throws IOException {
        return readFile.getElement("yearpicker");
    }

    public WebElement getDayPicker() throws IOException {
        return readFile.getElement("daypicker");
    }

    public List<WebElement> getCell() throws IOException {
        return readFile.getElements("cell");
    }

    public WebElement getStudentStrengthSubMenu() throws IOException {
        return readFile.getElement("studentstrengthsubmenu");
    }

    public WebElement getTableList() throws IOException {
        return readFile.getElement("tablelist");
    }
}