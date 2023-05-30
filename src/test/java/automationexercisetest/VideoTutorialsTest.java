package automationexercisetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;

public class VideoTutorialsTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());
    @Test
    public void videoTutorialsPageButton() {

        HomePage homePage = new HomePage(getDriver());
        VideoTutorialsPage videoTutorialsPage = new VideoTutorialsPage(getDriver());

        homePage.clickOnVideoTutorialsButton(); //navigate to products page

        //validate page header
        String expectedYoutubeHeader = "AutomationExercise";
        String actualYoutubeHeader= videoTutorialsPage.getYoutubeHeaderText30();
        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));
    }
}
