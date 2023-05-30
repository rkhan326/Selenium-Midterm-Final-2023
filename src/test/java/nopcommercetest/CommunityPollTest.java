package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.nopcommercepages.CommunityPollPage;
import us.piit.pages.nopcommercepages.LoginPage;

public class CommunityPollTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());
    LoginTest loginTest=new LoginTest();
    String validUsername= loginTest.validUsername;
    String validPassword= loginTest.validPassword;

    @Test(enabled = true, priority = 2)
    public void selectExcellentWithRegisteredEmail() {
        CommunityPollPage communityPollPage= new CommunityPollPage(getDriver());
        LoginPage loginPage= new LoginPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);

        communityPollPage.clickOnExcellentRadioButton();
        communityPollPage.clickOnVoteButton();

        String expectedText="Community poll";
        String actualText = communityPollPage.voteValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Vote validation Success");

    }

    @Test(enabled = true, priority = 1)
    public void selectExcellentWithoutRegisteredEmail() {
        CommunityPollPage communityPollPage= new CommunityPollPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        communityPollPage.clickOnExcellentRadioButton();
        communityPollPage.clickOnVoteButton();
        String expectedText = "Only registered users can vote.";
        String actualText = communityPollPage.voteSuccessfullyConfirmed();
        Assert.assertEquals(expectedText, actualText);

    }
    @Test(enabled = true, priority = 4)
    public void selectVeryGoodWithRegisteredEmail() {
        CommunityPollPage communityPollPage= new CommunityPollPage(getDriver());
        LoginPage loginPage= new LoginPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        //click on login
        loginPage.clickOnLoginText();
        waitFor(1);

        // check login page success
        Assert.assertTrue(loginPage.checkLoginPageSuccess());
        log.info("login page success");

        //enter  username,Password and click
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        scrollToCoordinates(0,100);
        loginPage.clickOnLoginBtn();
        waitFor(1);


        communityPollPage.clickOnEVeryGoodRadioButton();
        communityPollPage.clickOnVoteButton();

        String expectedText="Community poll";
        String actualText = communityPollPage.voteValidationText();
        Assert.assertEquals(expectedText,actualText);
        log.info("Vote validation Success");

    }
    @Test(enabled = true, priority = 3)
    public void selectVeryGoodWithoutRegisteredEmail() {
        CommunityPollPage communityPollPage= new CommunityPollPage(getDriver());
        //check we are nopcommerce website
        String expectedTitle = "nopCommerce demo store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        communityPollPage.clickOnEVeryGoodRadioButton();
        communityPollPage.clickOnVoteButton();
        String expectedText = "Only registered users can vote.";
        String actualText = communityPollPage.voteSuccessfullyConfirmed();
        Assert.assertEquals(expectedText, actualText);

    }


}
