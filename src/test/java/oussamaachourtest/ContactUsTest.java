package oussamaachourtest; //2 tests

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.oussamaachourpages.ContactUsPage;
import uspiit.pages.oussamaachourpages.HomePage;
import uspiit.pages.oussamaachourpages.LoginRegisterPage;


public class ContactUsTest extends CommonAPI {
    Logger log = LogManager.getLogger(ContactUsTest.class.getName());

    @Test(enabled = true)
    public void contactSupportTeam(){
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();

        //On the base menu click on contactus button
        loginRegisterPage.clickOnContactUsLink();

        //Assert we land on the contact us page
        Assert.assertTrue(contactUsPage.checkPresenceOfContactUsHeader());
        log.info("successfully validated the presence of the contact us header");

        //enter data and click on send message button
        contactUsPage.enterFirstName(contactUsPage.fakeCustomerFirstName());
        contactUsPage.enterLastName(contactUsPage.fakeCustomerLastName());
        contactUsPage.enterEmail(contactUsPage.fakeCustomerEmail());
        contactUsPage.enterMessageOrComment(contactUsPage.fakeCustomerMessageOrComment());
        contactUsPage.clickOnSendMessageBtn(getDriver());

        //assert the thank you for contacting us message is displayed
        Assert.assertTrue(contactUsPage.checkPresenceOfTYForContactingUsMessage());
        log.info("successfully validated the presence of thank you for contacting us message");

    }
    @Test(enabled = true)
    public void contactSupportTeamInvalidEmailCorrection(){
        HomePage homePage = new HomePage(getDriver());
        ContactUsPage contactUsPage = new ContactUsPage(getDriver());
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());

        //ensure we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account
        homePage.clickOnMyAccountLink();

        //On the base menu click on contactus button
        loginRegisterPage.clickOnContactUsLink();

        //Assert we land on the contact us page
        Assert.assertTrue(contactUsPage.checkPresenceOfContactUsHeader());
        log.info("successfully validated the presence of the contact us header");

        //enter data and click on send message button
        contactUsPage.enterFirstName(contactUsPage.fakeCustomerFirstName());
        contactUsPage.enterLastName(contactUsPage.fakeCustomerLastName());
        contactUsPage.enterEmail("razia");
        contactUsPage.clickOnMessageOrCommentField();

        //validate invalid email error message
        Assert.assertTrue(contactUsPage.checkPresenceOfInvalidEmailErrorMessage());

        //enter corrected email
        contactUsPage.enterEmail(contactUsPage.fakeCustomerEmail());
        contactUsPage.enterMessageOrComment(contactUsPage.fakeCustomerMessageOrComment());
        contactUsPage.clickOnSendMessageBtn(getDriver());

        //assert the thank you for contacting us message is displayed
        Assert.assertTrue(contactUsPage.checkPresenceOfTYForContactingUsMessage());
        log.info("successfully validated the presence of thank you for contacting us message");

    }




}
