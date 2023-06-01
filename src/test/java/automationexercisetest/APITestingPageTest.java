package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.APITestingPage;
import uspiit.pages.automationexercisepages.HomePage;
import uspiit.pages.automationexercisepages.ProductsPage;
import uspiit.pages.automationexercisepages.VideoTutorialsPage;

public class APITestingPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test
    public void apiTestingPageButton26() {
        HomePage homePage = new HomePage(getDriver());
        APITestingPage aPITestingPage = new APITestingPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnAPITestingButton(); //navigate to API Testing page
        waitFor(1);

        productsPage.clickOnAdButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedAPITestingPageHeader = "APIS LIST FOR PRACTICE";
        String actualAPITestingPageHeader= aPITestingPage.getAPITestingPageHeaderText();
        Assert.assertEquals(actualAPITestingPageHeader, expectedAPITestingPageHeader);
        log.info(homePage.wellDoneBoy.concat(expectedAPITestingPageHeader).concat(homePage.headerValidationSuccess));
    }
    @Test
    public void apTestngPageAPILink27() {
        HomePage homePage = new HomePage(getDriver());
        APITestingPage aPITestingPage = new APITestingPage(getDriver());
        ProductsPage productsPage = new ProductsPage(getDriver());

        homePage.clickOnAPITestingButton(); //navigate to API Testing page
        waitFor(1);

        productsPage.clickOnAdButton(getDriver());
        waitFor(1);

        //validate page header
        String expectedAPITestingPageHeader = "APIS LIST FOR PRACTICE";
        String actualAPITestingPageHeader= aPITestingPage.getAPITestingPageHeaderText();
        Assert.assertEquals(actualAPITestingPageHeader, expectedAPITestingPageHeader);
        log.info(homePage.wellDoneBoy.concat(expectedAPITestingPageHeader).concat(homePage.headerValidationSuccess));

        //scroll down to view API 14 link
        aPITestingPage.scrollToViewAPI14Link(getDriver());
        waitFor(1);

        //click on download invoice link
        aPITestingPage.clickOnAPILink();
    }
}
