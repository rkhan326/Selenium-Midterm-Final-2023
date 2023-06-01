package nopcommercetest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.nopcommercepages.CommunityPollPage;
import uspiit.pages.nopcommercepages.LoginPage;
import uspiit.utility.ExcelReader;

import java.io.File;

public class CommunityPollTest extends CommonAPI {
    Logger log = LogManager.getLogger(RegisterTest.class.getName());

    String currentDir = System.getProperty("user.dir");
    String path = currentDir+ File.separator+"data"+File.separator+"nopcommercedata.xlsx";
    ExcelReader excelReader = new ExcelReader(path);
    String validEmail= excelReader.getStringDataFromCell("data",10,1);
    String validPassword= excelReader.getStringDataFromCell("data",8,1);

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
        loginPage.enterUsername(validEmail);
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
        loginPage.enterUsername(validEmail);
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
