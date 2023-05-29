package us.piit.pages.automationexercisepages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class VideoTutorialsPage extends CommonAPI {
    Logger log = LogManager.getLogger(VideoTutorialsPage.class.getName());

    public VideoTutorialsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
