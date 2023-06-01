package oussamaachourtest; //2 tests

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import uspiit.base.CommonAPI;
import uspiit.pages.oussamaachourpages.HomePage;
import uspiit.pages.oussamaachourpages.LoginRegisterPage;
import uspiit.pages.oussamaachourpages.MyAccountPage;
import uspiit.utility.Utility;

import java.util.Properties;

public class LogoutTest extends CommonAPI {
    Logger log = LogManager.getLogger(LogoutTest.class.getName());
    Properties prop = Utility.loadProperties();
    String validLoginUsername = Utility.decode(prop.getProperty("oussamaachour.login-username"));
    String validLoginPassword = Utility.decode(prop.getProperty("oussamaachour.login-password"));


    @Test(enabled = true)
    public void logoutWithButtonOnMenuTest() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());


        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account btn on homepage
        homePage.clickOnMyAccountLink();

        // enter username, password and click on login btn on login page
        loginRegisterPage.enterLoginUsername(validLoginUsername);
        loginRegisterPage.enterLoginPassword(validLoginPassword);
        loginRegisterPage.clickOnLoginBtn();


        //make sure user lands on login page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);

        //click on logout button
        myAccountPage.clickOnLogOutBtnOnMenu();

        //assert that we land on the login page
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginHeader());

    }
    @Test(enabled = true )
    public void logoutWithButtonOnBodyTest() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());


        //Assert we are on the correct website
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        String actualTitle = getCurrentTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //click on my account btn on homepage
        homePage.clickOnMyAccountLink();

        // enter username, password and click on login btn on login page
        loginRegisterPage.enterLoginUsername(validLoginUsername);
        loginRegisterPage.enterLoginPassword(validLoginPassword);
        loginRegisterPage.clickOnLoginBtn();


        //make sure user lands on login page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);

        //click on logout button
        myAccountPage.clickOnLogOutBtnOnBody();

        //assert that we land on the login page
        Assert.assertTrue(loginRegisterPage.checkPresenceOfLoginHeader());

    }
}
