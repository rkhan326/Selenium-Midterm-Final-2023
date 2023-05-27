package us.piit.pages.oussamaachourpages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import us.piit.base.CommonAPI;

public class SingleProductPage extends CommonAPI {
    Logger log = LogManager.getLogger(SingleProductPage.class.getName());

    public SingleProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy( css = "h1[class = 'entry-title']")
    WebElement camerasCameraC430W;
    @FindBy( xpath = "//h1[text()='Camera C430W 4k with  Waterproof cover']")
    WebElement camerasCameraC430WPageHeader;

    public boolean checkPresenceOfCameraC430WHeader(){
        boolean CameraC430WHeaderIsDisplayed = isVisible(camerasCameraC430WPageHeader);
        log.info("login invalid password error message validation success.");
        return CameraC430WHeaderIsDisplayed;
    }



}
