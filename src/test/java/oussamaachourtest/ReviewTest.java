package oussamaachourtest; //4 tests

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.SingleProductPage;
import us.piit.utility.DataProviderClass;

public class ReviewTest extends CommonAPI {
    Logger log = LogManager.getLogger(oussamaachourtest.RegisterTest.class.getName());

    @Test(enabled = false)
    public void leaveAReviewUsingFaker() {
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //scroll to and click on item: camera c430w
        homePage.clickOnCameraC430WLink(getDriver());

        //assert landing on single product page
        Assert.assertTrue(singleProductPage.checkPresenceOfCameraC430WHeader());
        log.info("camera c430W page header is displayed");

        //Click on the review tab and assert opening review tab
        singleProductPage.clickOnCameraC430WPageReviewLink(getDriver());
        Assert.assertTrue(singleProductPage.checkPresenceOfAddAReviewHeader(getDriver()));
        log.info("add a review header is displayed");

        //enter review data and click on add review button
        singleProductPage.clickOn5StarsForReview();
        singleProductPage.enterReviewText(singleProductPage.enterFakeReviewText1());
        waitFor(3);
        singleProductPage.enterReviewerName(singleProductPage.enterFakeReviewerName());
        waitFor(3);
        singleProductPage.enterReviewerEmail(singleProductPage.enterFakeReviewerEmail());
        waitFor(3);
        singleProductPage.clickOnSaveInfoCheckBox();
        singleProductPage.clickOnAddReviewBtn();

        //assert seeing the review awaiting approval message
        Assert.assertTrue(singleProductPage.checkPresenceOfReviewAwaitingApprovalMessage(getDriver()));
        log.info("review awaiting approval message is displayed");
    }


    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "excelDPOussamaReviewTest", enabled = true)
    public void leaveAReviewUsingDataProvider(String stars, String review, String name, String email) {
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //scroll to and click on item: camera c430w
        homePage.clickOnCameraC430WLink(getDriver());

        //assert landing on single product page
        Assert.assertTrue(singleProductPage.checkPresenceOfCameraC430WHeader());
        log.info("camera c430W page header is displayed");

        //Click on the review tab and assert opening review tab
        singleProductPage.clickOnCameraC430WPageReviewLink(getDriver());
        Assert.assertTrue(singleProductPage.checkPresenceOfAddAReviewHeader(getDriver()));
        log.info("add a review header is displayed");

        //enter review data and click on add review button
        switch (stars) {
            case "1.0":
                singleProductPage.clickOn1StarForReview();
                break;
            case "2.0":
                singleProductPage.clickOn2StarsForReview();
                break;
            case "3.0":
                singleProductPage.clickOn3StarsForReview();
                break;
            case "4.0":
                singleProductPage.clickOn4StarsForReview();
                break;
            case "5.0":
                singleProductPage.clickOn5StarsForReview();
                break;
        }

        //enter review data and click on add review button
        singleProductPage.enterReviewText(review);
        singleProductPage.enterReviewerName(name);
        singleProductPage.enterReviewerEmail(singleProductPage.enterFakeReviewerEmail());
        singleProductPage.clickOnSaveInfoCheckBox();
        singleProductPage.clickOnAddReviewBtn();

        //assert seeing the review awaiting approval message
        Assert.assertTrue(singleProductPage.checkPresenceOfReviewAwaitingApprovalMessage(getDriver()));
        log.info("review awaiting approval message is displayed");
    }

    @Test(enabled = false)
    public void duplicateReviewCorrection() {
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //scroll to and click on item: camera c430w
        homePage.clickOnCameraC430WLink(getDriver());

        //assert landing on single product page
        Assert.assertTrue(singleProductPage.checkPresenceOfCameraC430WHeader());
        log.info("camera c430W page header is displayed");

        //Click on the review tab and assert opening review tab
        singleProductPage.clickOnCameraC430WPageReviewLink(getDriver());
        Assert.assertTrue(singleProductPage.checkPresenceOfAddAReviewHeader(getDriver()));
        log.info("add a review header is displayed");

        //enter review data and click on add review button
        singleProductPage.clickOn5StarsForReview();
        singleProductPage.enterReviewText("duplicate review");
        waitFor(3);
        singleProductPage.enterReviewerName("charlie brown");
        waitFor(3);
        singleProductPage.enterReviewerEmail("charliebrown@gmail.com");
        waitFor(3);
        singleProductPage.clickOnSaveInfoCheckBox();
        singleProductPage.clickOnAddReviewBtn();

        //assert the error message
        Assert.assertTrue(singleProductPage.checkPresenceOfDuplicateReviewErrorMessage());
        log.info("duplicate error message validation success.");

        //click on back button
        singleProductPage.clickOnErrorBackButton();

        //reenter necessary data
        singleProductPage.clickOn5StarsForReview();
        singleProductPage.enterReviewText(singleProductPage.enterFakeReviewText1());
        singleProductPage.clickOnAddReviewBtn();

        //assert seeing the review awaiting approval message
        Assert.assertTrue(singleProductPage.checkPresenceOfReviewAwaitingApprovalMessage(getDriver()));
        log.info("review awaiting approval message is displayed");

    }


    @Test(enabled = false)
    public void invalidEmailReviewCorrection() {
        HomePage homePage = new HomePage(getDriver());
        SingleProductPage singleProductPage = new SingleProductPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //scroll to and click on item: camera c430w
        homePage.clickOnCameraC430WLink(getDriver());

        //assert landing on single product page
        Assert.assertTrue(singleProductPage.checkPresenceOfCameraC430WHeader());
        log.info("camera c430W page header is displayed");

        //Click on the review tab and assert opening review tab
        singleProductPage.clickOnCameraC430WPageReviewLink(getDriver());
        Assert.assertTrue(singleProductPage.checkPresenceOfAddAReviewHeader(getDriver()));
        log.info("add a review header is displayed");

        //enter review data and click on add review button
        singleProductPage.clickOn5StarsForReview();
        singleProductPage.enterReviewText(singleProductPage.enterFakeReviewText());
        waitFor(3);
        singleProductPage.enterReviewerName(singleProductPage.enterFakeReviewerName());
        waitFor(3);
        singleProductPage.enterReviewerEmail("charliebrown");
        waitFor(3);
        singleProductPage.clickOnSaveInfoCheckBox();
        singleProductPage.clickOnAddReviewBtn();

        //assert the error message
        Assert.assertTrue(singleProductPage.checkPresenceOfInvalidEmailErrorMessage());
        log.info("invalid email error message validation success.");

        //click on back button
        singleProductPage.clickOnErrorBackButton();

        //reenter necessary data
        singleProductPage.clickOn5StarsForReview();
        singleProductPage.enterReviewerEmail(singleProductPage.enterFakeReviewerEmail());
        singleProductPage.clickOnAddReviewBtn();

        //assert seeing the review awaiting approval message
        Assert.assertTrue(singleProductPage.checkPresenceOfReviewAwaitingApprovalMessage(getDriver()));
        log.info("review awaiting approval message is displayed");
    }
}
