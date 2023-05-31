package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.ContactUsPage;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;

public class ContactUsPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test
    public void contactUsPageButton28() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedContactUsHeader = "GET IN TOUCH";
        String actualContactUsHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualContactUsHeader, expectedContactUsHeader);
        log.info(homePage.wellDoneBoy.concat(expectedContactUsHeader).concat(homePage.headerValidationSuccess));
    }
    @Test
    public void contactUsSubmitReview29() {
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedYoutubeHeader = "GET IN TOUCH";
        String actualYoutubeHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));

        contactUsPage.enterReviewContactUsPage(getDriver()); //submit Review
    }
}
