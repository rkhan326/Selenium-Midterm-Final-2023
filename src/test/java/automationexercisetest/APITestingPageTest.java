package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.APITestingPage;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.ProductsPage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;

public class APITestingPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test (groups = {}, priority = 26, enabled = true)
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
    @Test (groups = {}, priority = 27, enabled = true)
    public void apiTestngPageLink27() {
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
