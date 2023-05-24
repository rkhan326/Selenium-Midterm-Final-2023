package oussamaachourtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;

import static java.sql.DriverManager.getDriver;

public class ReviewTest extends CommonAPI {
    Logger log = LogManager.getLogger(oussamaachourtest.RegisterTest.class.getName());
    @Test(enabled=true)
    public void leaveAReview(){
        HomePage homePage = new HomePage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //scroll to and click on item: camera c430w
        homePage.clickOnCameraC430WLink(getDriver());



    }




}
