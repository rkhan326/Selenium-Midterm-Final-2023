package oussamaachourtest;


import com.github.javafaker.Faker;
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

   //use data faker
   // String newRegistrationUsername = prop.getProperty("oussamaachour.registration-username");
   // String newRegistrationPassword = prop.getProperty("oussamaachour.registration-password");
   String existingRegistrationUsername = prop.getProperty("oussamaachour.registration-username");
   String existingRegistrationPassword = prop.getProperty("oussamaachour.registration-password");
   String newVendorRegistrationFirstName = prop.getProperty("oussamaachour.registration-vendor.firstname");
   String newVendorRegistrationLastName = prop.getProperty("oussamaachour.registration-vendor.lastname");
   String newVendorRegistrationShopName = prop.getProperty("oussamaachour.registration-vendor.shopname");
   String newVendorRegistrationShopUrl = prop.getProperty("oussamaachour.registration-vendor.shopurl");
   String newVendorRegistrationShopContact = prop.getProperty("oussamaachour.registration-vendor.shopcontact");

    Faker faker = new Faker();
    String vendorFirstName = faker.name().firstName();
    String vendorLastName = faker.name().lastName();
    String vendorShopName = faker.company().name();
    String vendorShopUrl = faker.company().url();
    String vendorShopContact = faker.phoneNumber().phoneNumber();

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
        Assert.assertTrue(loginRegisterPage.checkPresenceOfRegistrationErrorMessage());

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

        //click on vendor radio button
        loginRegisterPage.clickOnVendorRadioBtn();
        Assert.assertFalse(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertTrue(loginRegisterPage.checkVendorRadioBtnIsChecked());


        //new fields appear after hitting vendor radio button
        //enter first name, last name, shop name, shop url, shop contact


//        loginRegisterPage.enterRegistrationVendorFirstName(newVendorRegistrationFirstName);
//        loginRegisterPage.enterRegistrationVendorLastName(newVendorRegistrationLastName);
//        loginRegisterPage.enterRegistrationVendorShopName(newVendorRegistrationShopName);
//        loginRegisterPage.enterRegistrationVendorShopUrl(newVendorRegistrationShopUrl);
//        loginRegisterPage.enterRegistrationVendorShopContact(newVendorRegistrationShopContact);

        loginRegisterPage.enterRegistrationVendorFirstName(vendorFirstName);
        loginRegisterPage.enterRegistrationVendorLastName(vendorLastName);
        loginRegisterPage.enterRegistrationVendorShopName(vendorShopName);
        loginRegisterPage.enterRegistrationVendorShopUrl(vendorShopUrl);
        loginRegisterPage.enterRegistrationVendorShopContact(vendorShopContact);

        //scroll to register button
        scrollToCoordinates(0,300);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

       //Make sure we land on the vendor login page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);

        //check if vendor gets added to StoreList

    }
}
