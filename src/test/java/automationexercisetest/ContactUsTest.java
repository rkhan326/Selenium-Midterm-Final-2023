package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.ContactUsPage;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;

public class ContactUsTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());
    @Test
    public void contactUsPageButton28() {

        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());

        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedContactUsHeader = "AutomationExercise";
        String actualContactUsHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualContactUsHeader, expectedContactUsHeader);
        log.info(homePage.wellDoneBoy.concat(expectedContactUsHeader).concat(homePage.headerValidationSuccess));
    }
//    @Test
    public void contactUsSubmitReview28() {

        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());


        homePage.clickOnContactUsButton(); //navigate to products page

        //validate page header
        String expectedYoutubeHeader = "AutomationExercise";
        String actualYoutubeHeader= contactUsPage.getContactUsHeaderText();
        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));
    }

}
