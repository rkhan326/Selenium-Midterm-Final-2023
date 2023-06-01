package uspiit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import uspiit.base.CommonAPI;

public class TestCasesPage extends CommonAPI {

    Logger log = LogManager.getLogger(TestCasesPage.class.getName());
    public TestCasesPage(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//b[text()='Test Cases']")
    WebElement $testCasesPageHeader;
    @FindBy(xpath = "//u[text()='Test Case 24: Download Invoice after purchase order']")
    WebElement $downloadInvoiceText;
    @FindBy(xpath = "//h2[text()='Subscription']")
    WebElement $subscribtionText;
    @FindBy(xpath = "#subscribe")
    WebElement $subscribeButton;

    public String getTestCasesPageHeaderText() {
        String text = getElementText($testCasesPageHeader);
        log.info("Ya did it! 'Test Cases Page header' text acquisition success!!");
        return text;
    }
    public void clickOnDownloadInvoiceLink() {
        clickOn($downloadInvoiceText);
        log.info("Well done my guy! Click click on 'Download Invoice link' success!!");
    }
    public void scrollToViewDownloadInvoiceLink(WebDriver driver){
        scrollToView(driver,$subscribtionText);
        log.info("Well done my guy! View 'Download Invoice link' success!!");
    }
}

