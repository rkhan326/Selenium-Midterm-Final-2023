package oussamaachourtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import us.piit.base.CommonAPI;
import us.piit.pages.oussamaachourpages.*;
import us.piit.utility.Utility;

import java.util.Properties;

public class RegisterTest extends CommonAPI {
   Logger log = LogManager.getLogger(oussamaachourtest.RegisterTest.class.getName());
   Properties prop = Utility.loadProperties();
   String existingRegistrationUsername =  Utility.decode(prop.getProperty("oussamaachour.registration-username"));
   String existingRegistrationPassword = Utility.decode(prop.getProperty("oussamaachour.registration-password"));

    @Test(enabled = false, priority = 0)
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
        loginRegisterPage.enterRegistrationUsername(loginRegisterPage.newFakeRegistrationLoginUsername());
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.newFakeRegistrationLoginPassword());

        //click on radio button
        loginRegisterPage.clickOnCustomerRadioBtn();
        Assert.assertTrue(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertFalse(loginRegisterPage.checkVendorRadioBtnIsChecked());

        //scroll to register button
        loginRegisterPage.scrollToRegisterBtnwJS(getDriver());
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

        //Make sure we land on the "My Account" page successfully
        Assert.assertTrue(myAccountPage.checkPresenceOfMyAccountHeader());

        String myAccountExpectedHeaderText = "My Account";
        String myAccountActualHeaderText = myAccountPage.getMyAccountHeaderText();
        Assert.assertEquals(myAccountActualHeaderText, myAccountExpectedHeaderText);
    }

    @Test(enabled = false, priority = 1)
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
        loginRegisterPage.scrollToRegisterBtnwJS(getDriver());
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());


        //click on register button
        loginRegisterPage.clickOnRegisterBtn();;

        //validate error message
        Assert.assertTrue(loginRegisterPage.checkPresenceOfRegistrationErrorMessage());

    }

    @Test(enabled = false, priority = 3)
    public void registerNewVendorWithSetupWizard() {

        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        VendorWelcomePage vendorWelcomePage = new VendorWelcomePage(getDriver());
        VendorStoreListPage vendorStoreListPage = new VendorStoreListPage(getDriver());
        VendorStoreSetupPage vendorStoreSetupPage = new VendorStoreSetupPage(getDriver());
        VendorPaymentSetupPage vendorPaymentSetupPage = new VendorPaymentSetupPage(getDriver());
        VendorYourStoreIsReadyPage vendorYourStoreIsReadyPage = new VendorYourStoreIsReadyPage(getDriver());
        VendorDashboardPage vendorDashboardPage = new VendorDashboardPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
       // Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter username and password
        loginRegisterPage.enterRegistrationUsername(loginRegisterPage.newFakeRegistrationLoginUsername());
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.newFakeRegistrationLoginPassword());


        //scroll down
        scrollToCoordinates(0,300);
        waitFor(3);

        //click on vendor radio button
        loginRegisterPage.clickOnVendorRadioBtn();
        Assert.assertFalse(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertTrue(loginRegisterPage.checkVendorRadioBtnIsChecked());

        //new fields appear after hitting vendor radio button
        //enter FAKE first name, last name, shop name, shop url, shop contact
        String fakeShopName = loginRegisterPage.fakeVendorShopName();
        loginRegisterPage.enterRegistrationVendorFirstName(loginRegisterPage.fakeVendorFirstName());
        loginRegisterPage.enterRegistrationVendorLastName(loginRegisterPage.fakeVendorLastName());
        loginRegisterPage.enterRegistrationVendorShopName(fakeShopName);
        loginRegisterPage.enterRegistrationVendorShopUrl(loginRegisterPage.fakeVendorShopUrl());
        loginRegisterPage.enterRegistrationVendorShopContact(loginRegisterPage.fakeVendorShopContact());
        waitFor(3);

        //scroll to register button
        loginRegisterPage.scrollToRegisterBtnwJS(getDriver());
        waitFor(3);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());


        //click on register button
        loginRegisterPage.clickOnRegisterBtn();

        //Make sure we land on the vendor login page successfully
        Assert.assertTrue(vendorWelcomePage.checkPresenceOfVendorWelcomeHeader());

        String expectedVendorWelcomeHeaderText = "Welcome to Worldwide Electronics Store";
        String actualVendorWelcomeHeaderText = vendorWelcomePage.getVendorWelcomeHeaderText();
        Assert.assertEquals(expectedVendorWelcomeHeaderText, actualVendorWelcomeHeaderText);

        //click on vendor quick setup button on vendor login page
        vendorWelcomePage.clickOnVendorLetsGoBtn();

        //enter store setup data using faker data and hit continue
        vendorStoreSetupPage.enterStoreSetupStreet1Info(vendorStoreSetupPage.storeSetupFakeStreet1());
        vendorStoreSetupPage.enterStoreSetupStreet2Info(vendorStoreSetupPage.storeSetupFakeStreet2());
        vendorStoreSetupPage.enterStoreSetupCityInfo(vendorStoreSetupPage.storeSetupFakeCity());
        vendorStoreSetupPage.enterStoreSetupZipCodeInfo(vendorStoreSetupPage.storeSetupFakeZip());

        vendorStoreSetupPage.selectStoreSetupCountryFromDropdown("US", getDriver());
        //vendorStoreSetupPage.getCountryDropdownUSText()
        //vendorStoreSetupPage.clickOnStoreSetupCountryDropdown();

        // vendorStoreSetupPage.setStoreSetupCountryDropdown();
        vendorStoreSetupPage.selectStoreSetupStateFromDropdown("NY", getDriver());

        vendorStoreSetupPage.clickOnEmailShowInStoreCheckBox();
        vendorStoreSetupPage.clickOnStoreSetupContinueBtn();

        //enter Payment setup data using faker data and hit continue
        vendorPaymentSetupPage.enterPaymentSetupPaypalEmail(vendorPaymentSetupPage.paymentSetupFakePaypalEmail());
        vendorPaymentSetupPage.clickOnPaymentSetupContinueBtn();

        //click on go to your dashboard button on your store is ready page
        vendorYourStoreIsReadyPage.clickOnGoToYourDashboardBtn();

        //ensure we are on the dashboard page
        Assert.assertTrue(vendorDashboardPage.checkPresenceOfVendorDashboardHeader());

        String actualVendorDashboardHeaderText = vendorDashboardPage.getVendorDashboardHeaderText();
        String expectedVendorDashboardHeaderText = "Dashboard";
        Assert.assertEquals(actualVendorDashboardHeaderText, expectedVendorDashboardHeaderText);
        log.info("Successfully entered vendor dashboard page");

        //check if vendor gets added to StoreList
        homePage.clickOnStoresListLink();

        String expectedStoreListNewRegisteredShopNameText = fakeShopName;
        String actualStoreListNewRegisteredShopNameText = vendorStoreListPage.getStoreListNewRegisteredShopNameText();
        Assert.assertEquals(expectedStoreListNewRegisteredShopNameText, actualStoreListNewRegisteredShopNameText);

    }

    @Test(enabled = false, priority =2)
    public void registerNewVendorWithoutSetupWizard() {

        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        VendorWelcomePage vendorWelcomePage = new VendorWelcomePage(getDriver());
        VendorStoreListPage storeListPage = new VendorStoreListPage(getDriver());

        //ensure we are on the correct website
        String actualTitle = getCurrentTitle();
        String expectedTitle = "Welcome to Worldwide Electronics Store";
        Assert.assertEquals(actualTitle, expectedTitle);
        log.info("Successfully entered Oussama's website");

        //click on my account
        homePage.clickOnMyAccountLink();

        //enter username and password
        loginRegisterPage.enterRegistrationUsername(loginRegisterPage.newFakeRegistrationLoginUsername());
        loginRegisterPage.enterRegistrationPassword(loginRegisterPage.newFakeRegistrationLoginPassword());


        //scroll down
        scrollToCoordinates(0,300);
        waitFor(3);

        //click on vendor radio button
        loginRegisterPage.clickOnVendorRadioBtn();
        Assert.assertFalse(loginRegisterPage.checkCustomerRadioBtnIsChecked());
        Assert.assertTrue(loginRegisterPage.checkVendorRadioBtnIsChecked());

        //new fields appear after hitting vendor radio button
        //enter FAKE first name, last name, shop name, shop url, shop contact
        String fakeShopName = loginRegisterPage.fakeVendorShopName();
        loginRegisterPage.enterRegistrationVendorFirstName(loginRegisterPage.fakeVendorFirstName());
        loginRegisterPage.enterRegistrationVendorLastName(loginRegisterPage.fakeVendorLastName());
        loginRegisterPage.enterRegistrationVendorShopName(fakeShopName);
        loginRegisterPage.enterRegistrationVendorShopUrl(loginRegisterPage.fakeVendorShopUrl());
        loginRegisterPage.enterRegistrationVendorShopContact(loginRegisterPage.fakeVendorShopContact());
        waitFor(3);

        //scroll to register button
        scrollToCoordinates(0,500);
        Assert.assertTrue(loginRegisterPage.checkRegisterBtnIsVisible());
        waitFor(10);

        //click on register button
        loginRegisterPage.clickOnRegisterBtn();


        //Make sure we land on the vendor login page successfully
        Assert.assertTrue(vendorWelcomePage.checkPresenceOfVendorWelcomeHeader());

        String expectedVendorWelcomeHeaderText = "Welcome to Worldwide Electronics Store";
        String actualVendorWelcomeHeaderText = vendorWelcomePage.getVendorWelcomeHeaderText();
        Assert.assertEquals(expectedVendorWelcomeHeaderText, actualVendorWelcomeHeaderText);

        //check if vendor gets added to StoreList
        vendorWelcomePage.clickOnVendorNotRightNowBtn();

        homePage.clickOnStoresListLink();

        String expectedStoreListNewRegisteredShopNameText = fakeShopName;
        String actualStoreListNewRegisteredShopNameText = storeListPage.getStoreListNewRegisteredShopNameText();
        Assert.assertEquals(expectedStoreListNewRegisteredShopNameText, actualStoreListNewRegisteredShopNameText);

    }


}

