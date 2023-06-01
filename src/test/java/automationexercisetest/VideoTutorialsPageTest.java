package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.automationexercisepages.HomePage;
import uspiit.pages.automationexercisepages.VideoTutorialsPage;

public class VideoTutorialsPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test
    public void videoTutorialsPageButton30() {
        HomePage homePage = new HomePage(getDriver());
        VideoTutorialsPage videoTutorialsPage = new VideoTutorialsPage(getDriver());

        homePage.clickOnVideoTutorialsButton(); //navigate to Video Tutorials page

        //validate page header
        String expectedYoutubeHeader = "AutomationExercise";
        String actualYoutubeHeader= videoTutorialsPage.getYoutubeHeaderText();
        Assert.assertEquals(actualYoutubeHeader, expectedYoutubeHeader);
        log.info(homePage.wellDoneBoy.concat(expectedYoutubeHeader).concat(homePage.headerValidationSuccess));
    }
}
