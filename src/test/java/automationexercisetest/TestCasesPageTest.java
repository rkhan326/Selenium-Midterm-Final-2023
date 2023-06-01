package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.HomePage;
import uspiit.pages.automationexercisepages.ProductsPage;
import uspiit.pages.automationexercisepages.TestCasesPage;
import uspiit.pages.automationexercisepages.VideoTutorialsPage;

public class TestCasesPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test
    public void testCasesPageButton24() {

        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());

        homePage.clickOnTestCasesButton(); //navigate to Test Cases page
        waitFor(1);

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);

        //validate page header
        String expectedTestCasesPageHeader = "TEST CASES";
        String actualTestCasesPageHeader= testCasesPage.getTestCasesPageHeaderText();
        Assert.assertEquals(actualTestCasesPageHeader, expectedTestCasesPageHeader);
        log.info(homePage.wellDoneBoy.concat(expectedTestCasesPageHeader).concat(homePage.headerValidationSuccess));
    }
    @Test
    public void testCasesDownloadLink25() {
        HomePage homePage = new HomePage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());
        TestCasesPage testCasesPage = new TestCasesPage(getDriver());

        homePage.clickOnTestCasesButton(); //navigate to Test Cases page
        waitFor(1);

        productsPage.clickOnAdButton(getDriver());//click on Ad
        waitFor(1);

        //validate page header
        String expectedTestCasesPageHeader = "TEST CASES";
        String actualTestCasesPageHeader= testCasesPage.getTestCasesPageHeaderText();
        Assert.assertEquals(actualTestCasesPageHeader, expectedTestCasesPageHeader);
        log.info(homePage.wellDoneBoy.concat(expectedTestCasesPageHeader).concat(homePage.headerValidationSuccess));

        //scroll down to view download invoice link 24
        testCasesPage.scrollToViewDownloadInvoiceLink(getDriver());
        waitFor(1);

        //click on download invoice link
        testCasesPage.clickOnDownloadInvoiceLink();
    }
}

