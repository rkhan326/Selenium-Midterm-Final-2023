package oussamaachourtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.HomePage;
import us.piit.pages.oussamaachourpages.LoginRegisterPage;
import us.piit.pages.oussamaachourpages.MyAccountPage;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegisterTest extends CommonAPI {
   Logger log = LogManager.getLogger(oussamaachourtest.RegisterTest.class.getName());=
   Properties prop = Utility.loadProperties();
   //use datafaker
   // String newRegistrationUsername = prop.getProperty("oussamaachour.registration-username");
   // String newRegistrationPassword = prop.getProperty("oussamaachour.registration-password");
   String existingRegistrationUsername = prop.getProperty("oussamaachour.registration-username");
   String existingRegistrationPassword = prop.getProperty("oussamaachour.registration-password");

   // @Test
    public void registerNewCustomer() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter username and password
        loginRegisterPage.enterRegistrationUsername(newRegistrationUsername);
        loginRegisterPage.enterRegistrationPassword(newRegistrationPassword);

        //click on radio button
        loginRegisterPage.clickOnCustomerRadioBtn();
        Assert.assertTrue(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertFalse(loginRegisterPage.checkVendorRadioBtnIsChecked());

        //scroll to register button
        scrollToCoordinates(0,300);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

        //Make sure we land on the "My Account" page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
    }

    //@Test
    public void registerExistingCustomer() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter username and password
        loginRegisterPage.enterRegistrationUsername(existingRegistrationUsername);
        loginRegisterPage.enterRegistrationPassword(existingRegistrationPassword);

        //click on radio button
        loginRegisterPage.clickOnCustomerRadioBtn();
        Assert.assertTrue(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertFalse(loginRegisterPage.checkVendorRadioBtnIsChecked());

        //scroll to register button
        scrollToCoordinates(0,300);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

        //validate error message
        boolean errorMessageIsDisplayed = isVisible("//li[text()=' An account is already registered with your email address. ']");
        Assert.assertTrue(errorMessageIsDisplayed);
        log.info("error message validation success.");
    }

    //@Test
    public void registerNewVendor() {
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter username and password
        loginRegisterPage.enterRegistrationUsername(newRegistrationUsername);
        loginRegisterPage.enterRegistrationPassword(newRegistrationPassword);

        //scroll down
        scrollToCoordinates(0,300);
        waitFor(3);

        //click on radio button
        clickOn("//input[@value = 'seller']");
        waitFor(2);
        boolean isCustomerRadioButton = isChecked("//input[@value = 'customer']");
        Assert.assertFalse(isCustomerRadioButton);
        boolean isVendorRadioButton = isChecked("//input[@value = 'seller']");;
        Assert.assertTrue(isVendorRadioButton);
        log.info("click on vendor radio button success");

        //new fields appear after hitting vendor radio button
        //enter first name
        typeText("//input[@id ='first-name' ]", "Razia");
        log.info("enter first name success");
        waitFor(2);

        //enter last name
        typeText("//input[@id ='last-name' ]", "Khan");
        log.info("enter last name success");
        waitFor(2);


        //enter shop name
        typeText("//input[@id ='company-name' ]", "Razia and Co.");
        log.info("enter shop name success");
        waitFor(2);

        //enter shop url
        typeText("//input[@id ='seller-url' ]", "https://raziakhan.com");
        log.info("enter shop url success");
        waitFor(2);

        //enter phone number
        typeText("//input[@id ='shop-phone' ]", "718-888-8888");
        log.info("enter phone number success");
        waitFor(2);

        //scroll to register button
        scrollToCoordinates(0,300);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

       //Make sure we land on the vendor login page successfully
        boolean myAccountPageHeadedisDisplayed = isVisible("//h1[@id='wc-logo']");
        Assert.assertTrue(myAccountPageHeadedisDisplayed);
        log.info("My Account page header is displayed");
        String myAccountExpectedHeaderText = "Welcome to Worldwide Electronics Store";
        String myAccountActualHeaderText = getElementText("//h1[@id='wc-logo']");
        Assert.assertEquals(myAccountActualHeaderText,myAccountExpectedHeaderText);
        log.info("vendor login page validation text match success");

        //check if vendor gets added to StoreList

    }
}
