package automationexercisetest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.automationexercisepages.HomePage;
import us.piit.pages.automationexercisepages.VideoTutorialsPage;

public class VideoTutorialsPageTest extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    @Test (groups = {}, priority = 30, enabled = false)
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
